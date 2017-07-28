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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Type {


    /**
     * The constant STRING.
     */
    @NotNull
    public static final Type _STRING = new Type("STRING");
    /**
     * The constant DECIMAL.
     */
    @NotNull
    public static final Type _DECIMAL = new Type("DECIMAL");
    /**
     * The constant INTEGER.
     */
    @NotNull
    public static final Type _INTEGER = new Type("INTEGER");
    /**
     * The constant LIST.
     */
    @NotNull
    public static final Type _LIST = new Type("LIST");
    /**
     * The constant MAP.
     */
    @NotNull
    public static final Type _MAP = new Type("MAP");
    /**
     * The constant URI.
     */
    @NotNull
    public static final Type _URI = new Type("URI");
    /**
     * The constant VOID.
     */
    @NotNull
    public static final Type _VOID = new Type("VOID");
    /**
     * The constant RANGE.
     */
    @NotNull
    public static final Type _RANGE = new Type("RANGE");
    /**
     * The constant BOOLEAN.
     */
    @NotNull
    public static final Type _BOOLEAN = new Type("BOOLEAN");
    /**
     * The constant ERROR.
     */
    @NotNull
    public static final Type _ERROR = new Type("ERROR");
    /**
     * The constant DATE.
     */
    @NotNull
    public static final Type _DATE = new Type("DATE");
    /**
     * The constant INFINITY.
     */
    @NotNull
    public static final Type _INFINITY = new Type("INFINITY");
    /**
     * The constant ANY.
     */
    @NotNull
    public static final Type _ANY = new Type("ANY");

    @NotNull
    public static final Type _QUEUE = new Type("QUEUE");


    @NotNull private final String name;
    @NotNull private final String constraint;


    /**
     * Instantiates a new Type.
     *
     * @param name the name
     */
    public Type(@NotNull String name, @NotNull String constraint) {

        this.name = name.toUpperCase();
        this.constraint = constraint;
    }

    /**
     * Instantiates a new Type.
     *
     */
    public Type(@NotNull Type type, @NotNull String constraint) {

        this.name = type.name;
        this.constraint = constraint;
    }
    /**
     * Instantiates a new Type.
     *
     * @param name the name
     */
    public Type(@NotNull String name) {

        this.name = name.toUpperCase();
        this.constraint = "";
    }

    /**
     * Create a Type from a string or null if it doesn't exist.
     *
     * @param name the name of the Type
     *
     * @return the Type
     */
    public static Type valueOf(@NotNull String name) {
        String[] split = name.split(":");
        if(split.length==2) {
            return new Type(split[0], split[1]);
        } else {
            return new Type(name);
        }
    }



    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public boolean is(@Nullable Type t) {
        return name.equals(t != null ? t.name :null);

    }

    @NotNull @Override public String toString() {
        return name;
    }

    /**
     * Name string.
     *
     * @return the string
     */
    @NotNull public String name() {
        return name;
    }

}
