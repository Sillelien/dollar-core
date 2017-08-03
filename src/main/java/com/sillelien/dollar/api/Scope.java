/*
 *    Copyright (c) 2014-2017 Neil Ellis
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.sillelien.dollar.api;

import com.sillelien.dollar.api.collections.MultiMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface Scope {

    var addErrorHandler(@NotNull var handler);

    void clear();

    @NotNull var get(@NotNull String key, boolean mustFind);

    @Nullable var get(@NotNull String key);

    @Nullable var getConstraint(@NotNull String key);

    String getConstraintSource(@NotNull String key);



    @Nullable String getFile();

    @NotNull MultiMap<String, var> getListeners();

    @Nullable var getParameter(@NotNull String key);

    @Nullable Scope getScopeForKey(@NotNull String key);

    @Nullable Scope getScopeForParameters();

    @Nullable String getSource();

    @NotNull <T>  Map<String, T> getVariables();

    @NotNull var handleError(@NotNull Throwable t);

    boolean has(String key);

    boolean hasParameter(String key);

    void listen(@NotNull String key, @NotNull var listener);

    @Nullable var notify(@NotNull String variableName);

    void notifyScope(@NotNull String key, @NotNull var value);

    @NotNull var set(@NotNull String key, @NotNull var value, boolean readonly, @Nullable var constraint,
                     String constraintSource, boolean isVolatile,
            boolean fixed, boolean pure);

    @NotNull var setParameter(@NotNull String key, @NotNull var value);

    void setParent(@Nullable Scope scope);

    Scope getParent();
}
