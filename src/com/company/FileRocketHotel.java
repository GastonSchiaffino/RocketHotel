package com.company;

import java.io.File;
import java.io.IOException;

public interface FileRocketHotel {
     abstract void read(File file) throws IOException;
     abstract void write(File file) throws IOException;
}
