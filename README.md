# Bounce

Android's MotionEvent class only supports x, y axises (https://developer.android.com/reference/android/view/MotionEvent.html) . In order to propagate the Z-axis from ODG's WFC and other 3D devices, ODG added a custom API to the MotionEvent class, "getZ()", in the framework. For 3rd party developer to get access to it, developer needs to obtain ODG's extension library, "com.osterhoutgroup.api.ext.jar" and add it to project property. Then call the "getMotionEventZAxis()" method to get the z value. Steps:
<br/><br/>
1). Obtain our extented library and include it in yur libs folder.<br/>
2). Create an instance for OdgHardwareExt interface.<br/>
3). Pass the motion event to getMotionEventZAxis() in onTrackballEvent.<br/>
