#include <string.h>
#include <stdio.h>
#include <time.h>
#include <jni.h>


//Retorna uma String
jstring Java_br_com_heiderlopes_androidndk_MainActivity_getDataAtualJNI( JNIEnv* env, jobject o )
{
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[64];
    strftime(s, sizeof(s), "%c", tm);

    return (*env)->NewStringUTF(env, s);
}

//Retorna a soma de dois valores
jint JNICALL Java_br_com_heiderlopes_androidndk_MainActivity_somaJNI
        (JNIEnv * env, jobject obj, jint value1, jint value2) {
    return (value1 + value2);
}