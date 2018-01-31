/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.client.util;

import com.google.common.io.BaseEncoding;

/**
 * Proxy for base 64 encoding/decoding which matches the Base64 interface in Apache Commons (for
 * historical reasons).
 *
 * @author Yaniv Inbar
 * @since 1.8
 */
public class Base64 {

  /**
   * Encodes binary data using the base64 algorithm but does not chunk the output.
   *
   * @param binaryData binary data to encode or {@code null} for {@code null} result
   * @return byte[] containing Base64 characters in their UTF-8 representation or {@code null} for
   * {@code null} input
   */
  public static byte[] encodeBase64(byte[] binaryData) {
    if (binaryData == null) {
      return null;
    }
    return BaseEncoding.base64().encode(binaryData).getBytes();
  }

  /**
   * Encodes binary data using the base64 algorithm but does not chunk the output.
   *
   * @param binaryData binary data to encode or {@code null} for {@code null} result
   * @return String containing Base64 characters or {@code null} for {@code null} input
   */
  public static String encodeBase64String(byte[] binaryData) {
    if (binaryData == null) {
      return null;
    }
    return BaseEncoding.base64().encode(binaryData);
  }

  /**
   * Encodes binary data using a URL-safe variation of the base64 algorithm but does not chunk the
   * output. The url-safe variation emits - and _ instead of + and / characters.
   *
   * @param binaryData binary data to encode or {@code null} for {@code null} result
   * @return byte[] containing Base64 characters in their UTF-8 representation or {@code null} for
   * {@code null} input
   */
  public static byte[] encodeBase64URLSafe(byte[] binaryData) {
    if (binaryData == null) {
      return null;
    }
    return BaseEncoding.base64Url().omitPadding().encode(binaryData).getBytes();
  }

  /**
   * Encodes binary data using a URL-safe variation of the base64 algorithm but does not chunk the
   * output. The url-safe variation emits - and _ instead of + and / characters.
   *
   * @param binaryData binary data to encode or {@code null} for {@code null} result
   * @return String containing Base64 characters or {@code null} for {@code null} input
   */
  public static String encodeBase64URLSafeString(byte[] binaryData) {
    if (binaryData == null) {
      return null;
    }
    return BaseEncoding.base64Url().omitPadding().encode(binaryData);
  }

  /**
   * Decodes Base64 data into octets.
   *
   * @param base64Data Byte array containing Base64 data or {@code null} for {@code null} result
   * @return Array containing decoded data or {@code null} for {@code null} input
   */
  public static byte[] decodeBase64(byte[] base64Data) {
    if (base64Data == null) {
      return null;
    }
    return decodeBase64(new String(base64Data));
  }

  /**
   * Decodes a Base64 String into octets.
   *
   * @param base64String String containing Base64 data or {@code null} for {@code null} result
   * @return Array containing decoded data or {@code null} for {@code null} input
   */
  public static byte[] decodeBase64(String base64String) {
    if (base64String == null) {
      return null;
    }

    try {
      return BaseEncoding.base64().decode(base64String);
    } catch (IllegalArgumentException e) {
      return BaseEncoding.base64Url().omitPadding().decode(base64String);
    }
  }
}