package com.test.demo;

import java.io.File;
import java.io.FileFilter;

// FileFilter实现类
public class Test017 implements FileFilter {
    @Override
    public boolean accept(File file) {
        String fileString = file.toString().toLowerCase();
        if (file.isDirectory()) {
            return true;
        }
        if (file.isFile() && fileString.endsWith(".java")) {
            return true;
        }
        return false;
    }
}
