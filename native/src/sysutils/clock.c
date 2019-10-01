#include <jni.h>
#include <time.h>
#ifndef _Included_org_bitcharmer_os_Clock
#define _Included_org_bitcharmer_os_Clock

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jlong JNICALL Java_org_bitcharmer_os_Clock_clock_1gettime_1internal(JNIEnv *env, jclass cls, jint clock_type) {
    struct timespec ts;
    clock_gettime(clock_type, &ts);
    return ts.tv_sec * 1000000000 + ts.tv_nsec;
}

#ifdef __cplusplus
}
#endif
#endif