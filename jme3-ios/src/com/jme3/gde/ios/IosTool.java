/*
 *  Copyright (c) 2009-2012 jMonkeyEngine
 *  All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 * 
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 *  * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.gde.ios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 * Various tools for iOS deployment, discovers XCode and SDK locations, SDK
 * versions and installs the avian resource files.
 *
 * @author normenhansen
 */
public class IosTool {

    public static String getIosDeveloperRootName() {
        FileObject devRoot = getIosDeveloperRoot();
        if (devRoot != null) {
            return devRoot.getPath();
        }
        return null;
    }

    public static FileObject getIosDeveloperRoot() {
        File oldDevRoot = new File("/Developer");
        File newDevRoot = new File("/Applications/Xcode.app/Contents/Developer");
        if (newDevRoot.exists() && newDevRoot.isDirectory()) {
            return FileUtil.toFileObject(newDevRoot);
        } else if (oldDevRoot.exists() && oldDevRoot.isDirectory()) {
            return FileUtil.toFileObject(oldDevRoot);
        }
        return null;
    }

    public static List<String> getIosSdkVersions(String target) {
        ArrayList<String> sdkList = new ArrayList<String>();
        FileObject devRoot = getIosDeveloperRoot();
        if (devRoot == null) {
            return sdkList;
        }
        FileObject sdkRoot = devRoot.getFileObject("Platforms/" + target + ".platform/Developer/SDKs");
        FileObject[] sdks = sdkRoot.getChildren();
        for (FileObject fileObject : sdks) {
            if (fileObject.isFolder()) {
                if (fileObject.getName().equals(target)) {
                    sdkList.add("default"); // instead of an empty field, we add "default"
                } else if (fileObject.getName().startsWith(target)) {
                    sdkList.add(fileObject.getName().substring(target.length(), fileObject.getName().length()));
                }
            }
        }
        return sdkList;
    }

}
