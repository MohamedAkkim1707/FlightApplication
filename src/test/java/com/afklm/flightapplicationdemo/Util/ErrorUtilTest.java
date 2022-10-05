package com.afklm.flightapplicationdemo.Util;

import com.afklm.flightapplicationdemo.model.Error;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test classes for ErrorUtil
 *
 * @author t765566
 */
class ErrorUtilTest {


    @Test
    void testCreateMissingMandatoryInputError() {
        Error error = ErrorUtil.createMissingMandatoryInputError("testField");
        assertNotNull(error);
    }

}