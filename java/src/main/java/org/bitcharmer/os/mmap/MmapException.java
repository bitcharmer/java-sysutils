package org.bitcharmer.os.mmap;

public class MmapException extends Exception {

    public enum Error {
        EPERM		( 1,"Operation not permitted"),
        ENOENT		( 2,"No such file or directory"),
        ESRCH		( 3,"No such process"),
        EINTR		( 4,"Interrupted system call"),
        EIO		    ( 5,"I/O error"),
        ENXIO		( 6,"No such device or address"),
        E2BIG		( 7,"Argument list too long"),
        ENOEXEC		( 8,"Exec format error"),
        EBADF		( 9,"Bad file number"),
        ECHILD		(10,"No child processes"),
        EAGAIN		(11,"Try again"),
        ENOMEM		(12,"Out of memory"),
        EACCES		(13,"Permission denied"),
        EFAULT		(14,"Bad address"),
        ENOTBLK		(15,"Block device required"),
        EBUSY		(16,"Device or resource busy"),
        EEXIST		(17,"File exists"),
        EXDEV		(18,"Cross-device link"),
        ENODEV		(19,"No such device"),
        ENOTDIR		(20,"Not a directory"),
        EISDIR		(21,"Is a directory"),
        EINVAL		(22,"Invalid argument"),
        ENFILE		(23,"File table overflow"),
        EMFILE		(24,"Too many open files"),
        ENOTTY		(25,"Not a typewriter"),
        ETXTBSY		(26,"Text file busy"),
        EFBIG		(27,"File too large"),
        ENOSPC		(28,"No space left on device"),
        ESPIPE		(29,"Illegal seek"),
        EROFS		(30,"Read-only file system"),
        EMLINK		(31,"Too many links"),
        EPIPE		(32,"Broken pipe"),
        EDOM		(33,"Math argument out of domain of func"),
        ERANGE		(34,"Math result not representable");

        private final int errno;
        private final String desc;

        Error(final int errno, final String desc) {
            this.errno = errno;
            this.desc = desc;
        }

        public int getErrno() {
            return errno;
        }

        public String getDesc() {
            return desc;
        }

        public static Error forErrno(final int errno) {
            for (final Error error : Error.values())
                if (errno == error.errno) return error;

            throw new IllegalArgumentException();
        }
    }


    private final Error error;

    public MmapException(final Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "MmapException{" +
                "errno=" + error.name() +
                ", desc=" + error.desc +
                '}';
    }
}
