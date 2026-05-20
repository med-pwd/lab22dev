#include <jni.h>
#include <string>
#include <algorithm>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnisemo_MainActivity_helloFromJNI(JNIEnv* env, jobject thiz) {
    return env->NewStringUTF("Bonjour du C++ !");
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_jnisemo_MainActivity_factorial(JNIEnv* env, jobject thiz, jint n) {
    if (n <= 1) return 1;
    int res = 1;
    for (int i = 2; i <= n; i++) res *= i;
    return (jint)res;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnisemo_MainActivity_reverseString(JNIEnv* env, jobject thiz, jstring s) {
    const char* str = env->GetStringUTFChars(s, NULL);
    std::string stdStr(str);
    std::reverse(stdStr.begin(), stdStr.end());
    env->ReleaseStringUTFChars(s, str);
    return env->NewStringUTF(stdStr.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_jnisemo_MainActivity_sumArray(JNIEnv* env, jobject thiz, jintArray values) {
    jint *elems = env->GetIntArrayElements(values, 0);
    jsize len = env->GetArrayLength(values);
    int sum = 0;
    for (int i = 0; i < len; i++) sum += elems[i];
    env->ReleaseIntArrayElements(values, elems, 0);
    return sum;
}