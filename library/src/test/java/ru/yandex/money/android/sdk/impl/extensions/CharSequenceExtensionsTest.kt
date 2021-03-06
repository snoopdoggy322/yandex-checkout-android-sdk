/*
 * The MIT License (MIT)
 * Copyright © 2018 NBCO Yandex.Money LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the “Software”), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package ru.yandex.money.android.sdk.impl.extensions

import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CharSequenceExtensionsTest {

    @Test
    fun `valid phone number`() {
        // prepare
        val phone = "+7 987 654-32-10"

        // invoke
        val isPhoneNumber = phone.isPhoneNumber

        // assert
        assertThat("should be true", isPhoneNumber)
    }

    @Test
    fun `invalid phone numbers`() {
        // prepare
        val phones = listOf(
            "",
            "8-987-654-32-10",
            "+7-987-654-32-101",
            "+7-987-654-32",
            "+7 987 654-32",
            "+7-987",
            "+7 987",
            "+7-"
        )

        phones.forEach { phone ->
            // invoke
            val isPhoneNumber = phone.isPhoneNumber

            // assert
            assertThat("should be false for $phone", !isPhoneNumber)
        }
    }
}