
ReflectionFactory.getReflectionFactory().newConstructorForSerialization() is not supported in native-image

this is an example to reproduce it.

step 1: install jdk and graalvm：
```
sdk install java 17.0.10-graal
sdk use java 17.0.10-graal
sdk default java 17.0.10-graal 
```
step 2: compile java
```
javac HelloWorld.java
```
step 3: build in native-image
```
native-image HelloWorld --no-fallback  -H:SerializationConfigurationFiles=serialization-config.json
```


step 4: run binary file:
```
./helloworld
```


step 5: Exception:
```
Exception in thread "main" com.oracle.svm.core.jdk.UnsupportedFeatureError: SerializationConstructorAccessor class not found for declaringClass: [F (targetConstructorClass: java.lang.Object). Usually adding [F to serialization-config.json fixes the problem.
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.util.VMError.unsupportedFeature(VMError.java:92)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.reflect.serialize.SerializationSupport.getSerializationConstructorAccessor(SerializationSupport.java:143)
	at java.base@17.0.10/jdk.internal.reflect.MethodAccessorGenerator.generateSerializationConstructor(MethodAccessorGenerator.java:61)
	at java.base@17.0.10/jdk.internal.reflect.ReflectionFactory.generateConstructor(ReflectionFactory.java:463)
	at java.base@17.0.10/jdk.internal.reflect.ReflectionFactory.newConstructorForSerialization(ReflectionFactory.java:376)
	at jdk.unsupported@17.0.10/sun.reflect.ReflectionFactory.newConstructorForSerialization(ReflectionFactory.java:100)
	at HelloWorld.main(HelloWorld.java:13)
```
