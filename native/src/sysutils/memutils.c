#ifndef _Included_org_bitcharmer_os_mmap_Mmap
#define _Included_org_bitcharmer_os_mmap_Mmap

#include <sys/mman.h>
#include <errno.h>
#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jlong JNICALL Java_org_bitcharmer_os_mmap_Mmap_mmap(JNIEnv *env, jclass cls, jint fd, jlong size, jint prot, jint flags, jlong offset, jlong errnoAddr) {
    void *result = mmap(NULL, size, prot, flags, fd, offset);
    *(long int*) errnoAddr = errno;

    return result;
}

JNIEXPORT jint JNICALL Java_org_bitcharmer_os_mmap_Mmap_unmap(JNIEnv *env, jclass cls, jlong addr, jlong size, jlong errnoAddr) {
    int result = munmap(addr, size);
    *(long int*)(errnoAddr) = errno;

    return result;
}

#ifdef __cplusplus
}
#endif
#endif

