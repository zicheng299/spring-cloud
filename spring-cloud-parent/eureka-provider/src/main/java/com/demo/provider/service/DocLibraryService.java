package com.demo.provider.service;

import org.bouncycastle.operator.OperatorException;

public interface DocLibraryService {
    String operation(String resourceId, String userId, Boolean isFollow) throws OperatorException;
}
