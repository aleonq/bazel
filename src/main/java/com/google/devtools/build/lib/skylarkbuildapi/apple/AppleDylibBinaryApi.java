// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.skylarkbuildapi.apple;

import com.google.devtools.build.lib.skylarkbuildapi.FileApi;
import com.google.devtools.build.lib.skylarkbuildapi.StructApi;
import com.google.devtools.build.lib.skylarkinterface.SkylarkCallable;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModule;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModuleCategory;

/**
 * A provider containing the executable binary output that was built using an apple_binary
 * target with the 'dylib' type.
 */
@SkylarkModule(
    name = "AppleDylibBinary",
    category = SkylarkModuleCategory.PROVIDER,
    doc = "A provider containing the executable binary output that was built using an apple_binary "
        + "target with the 'dylib' type."
)
public interface AppleDylibBinaryApi extends StructApi {

  @SkylarkCallable(name = "binary",
      structField = true,
      doc = "The dylib file output by apple_binary."
  )
  public FileApi getAppleDylibBinary();

  @SkylarkCallable(name = "objc",
      structField = true,
      doc = "A provider which contains information about the transitive dependencies linked into "
          + "the dylib, (intended so that binaries depending on this dylib may avoid relinking "
          + "symbols included in the dylib."
  )
  public ObjcProviderApi<?> getDepsObjcProvider();
}
