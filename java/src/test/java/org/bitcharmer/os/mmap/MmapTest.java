package org.bitcharmer.os.mmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;

class MmapTest {

//    @Test
    void shouldMmap() throws IOException {
        final RandomAccessFile raf = new RandomAccessFile("/dev/shm/mmap_test_01", "rw");
        final FileDescriptor fd = raf.getFD();
        long addr = 0;

        try {
            addr = Mmap.mmap(fd, 8192, Mmap.Prot.PROT_READ | Mmap.Prot.PROT_READ, Mmap.Flags.MAP_SHARED | Mmap.Flags.MAP_HUGETLB, 0);
        } catch (MmapException e) {
            e.printStackTrace();
        }

        System.out.println("Addr: " + addr);
        Assertions.assertTrue(addr != 0);
    }

}