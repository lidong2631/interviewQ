From Google

eeeeeaaaff -> e5a3f2

public int inplaceCompress(char[] arr) {
    int arrLen = arr.length, len = 0;   //len用来标记压缩后的字符串长度
    int count = 1;
    for(int i=1; i<arrLen; i++) {
        if(arr[i]==arr[len])    //如果重复 累加count
            count++;
        else {              //当新字符出现 检查count是否为1
            if(count!=1) {
                len++;
                arr[len] = (char)('0'+count%10);    //放数字 这里更严谨要判断长度大于9 要获取到长度位数，然后将长度数字copy到String上
            }
            len++;
            arr[len] = arr[i];  //放新的字符
            count = 1;
        }
        if(i==arrLen-1) {   //当处理结束时，需要计算一下最后一个字符出现的次数
            if(count!=1) {
                len++;
                arr[len] = (char)('0'+count%10);
            }
        }
    }
    return len;
}

in place压缩了arr 返回有效长度len

不移动数据，可以增加一个标记。标记压缩后的字符串的长度。这样就可以一个数组两个用途了

另外，还有一个问题，就是在其中一个字符长度大于9时的处理方法。如果长度大于9，需要获取到长度位数，然后将长度数字copy到String上。

下面实现的代码没有考虑这种情况

http://jbm3072.iteye.com/blog/1073310