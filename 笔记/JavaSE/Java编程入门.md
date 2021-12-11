### 一、Java 基本概念

1.`Alt+/` ：代码辅助菜单

2.JAVA工作方式：

- 编写源代码文件  *.java
- 编译后产生字节码文件    java文件路径下cmd-javac *.java
- JVM找到CLASSPATH的路径加载字节码文件，解释程序   cmd- java *

3.**JDK与JRE区别？**

> JDK是Java的开发工具包，它提供了JAVA的开发环境（编译器javac将java文件翻译为class文件）和运行环境，用于解析class文件。
>
> JRE是Java的运行环境，面向使用者，只能运行JAVA程序，它包括了JAVA虚拟机、JAVA平台核心类和支持文件，不包含开发工具（编辑器和调试器等）

4.**面试题：PATH和CLASSPATH的区别？**

> PATH:是操作系统提供的路径配置，定义所有可执行程序的路径
>
> CLASSPATH：是由JRE提供的，用于解释JAVA程序解释时类加载路径，默认为当前目录加载

5.注释：

> ```java
> //单行注释
> /*
> 多行注释
> */
> ```

### 二、数据类型分类

#### 2.1 基本数据类型

- 数值型：整型（byte  short  int  long: 默认0）；浮点型（float double: 默认0.0）
- 布尔型：boolean：默认false
- 字符型：char：默认'\u0000'   ，可以保存中文字

1. 默认常量整数是int型，默认小数是double型

2. 数据溢出：在对数字进行处理时如果超出了最大的保存范围，将出现循环问题。

   - 小转大自动适配，但不能将大范围转换为小范围数据类型(丢失)     `采用强制转换`

     ```java
     long a = 100L;
     float y = 10.1F;   
     float x = (float)10.2;
     ```

   - 两数运算时，结果取大的数据类型；注意选择的数据类型，决定小数点

   - char 型与int可以转换（ASCLL码）,char也可用来保存中文

     > A:65 —Z:90     a:97—z:122

     ```java
     char c = '中';
     ```

   - +即可以表示字符串的连接，也可以表示算术。

     > 其中范围String>double>int

     ```java
     int x = 10; double y = 0.2;
     String str = "计算结果："+(x+y);                 
     ```
     
   - **注意**：Java中任何变量都要指定数据类型
   
3. 转义字符

   > TAB:\t    、   换行：\n       、    ' :   \ '          、     “ ：\ ”         、       \ : \ \

4. 简化运算（减少内存空间）：+=  、 -=   、 *=  、   %=    、  /=  

   ++i，--i:先进行变量的自增、减，而后再进行数字运算

   i++,i--:先进行变量计算，在自增、减

#### 2.2 引用数据类型

牵扯到内存关系的使用，包括数组、类、接口

#### 2.3 使用规则

- 整数首选int ,小数首选double
- 数据传输、文字编码转换用byte
- 处理中文方便用char
- 描述内存/文件大小，描述表的主键列用long



### 三、Java运算符

#### 3.1 三目运算符

> 关系运算 ？ 关系满足时内容：关系不满足时内容

```java
max = x > y ? x:y;    //保存最大
max =x > y ? (x > z?x : z):(y > z?y : z); //指出三个最大
```

#### 3.2 位运算

> 与(&)、或(|)、非(~)、异或(^)、移位(<<)

**面试题：请解释&和&&、|和||的区别？**

1.&和|两个运算符可以进行逻辑运算和位运算

2.在逻辑运算中还可以用&&和||，&&中有一个false便false；||中有一个true便是true

### 四、逻辑控制

#### 4.1 IF分支

```java
double score = 90.00;
if(score >= 90 && score < 100) {
	System.out.println("Excellent!");
}else if(score >= 60) {
	System.out.println("Good!");
}else {
	System.out.println("Failed!");
}
```

#### 4.2 Switch分支

> switch是开关语句，根据内容可以用来判断(int,char,String)

```java
String str = "Hello";
switch(str) {
case "hello":
	System.out.println("hello!");
	break;
case "Hello":
	System.out.println("Hello!");
	break;
default:
	System.out.println("没有匹配成功！");
}
```

#### 4.3 while循环结构

> while循环：先判断后执行；do-while循环：先执行后判断。
>
> 只要满足布尔表达式为True。

```java
//实现1-100的累加
int sum = 0;
int i = 0;
while (i <= 100) {
	sum += i;
	i++;
}
System.out.println(sum);
```

#### 4.4 for 循环控制

> for(定义循环的初始化数值；循环判断；修改循环数据结构){}

```java
int sum = 0;
for (int x= 1; x <= 100; x++) {
	sum += x;
}
System.out.println(sum);
```

**注意：**对于while和for循环的选择只有一个标准：

- 在明确循环次数的情况下优先选择for
- 在不知循环次数但是知道循环条件的用while循环

#### 4.5 循环控制

- break:退出整个循环结构
- continue:结束当前轮次循环，继续下一个循环

#### 4.6 循环嵌套

1.打印9*9乘法表：

```java
for(int i = 1; i<=9; i++){
	for(int j = 1; j<= i;j++){
		System.out.print(j+" * "+i+" = "+(i*j)+"\t");
	}
	System.out.println("");
}
```

2.打印△

```java
int line = 10;
for(int i = 1;i<=line;i++){
	for(int j = 1;j<=line-i;j++){
		System.out.print(" ");	
	}
	for(int num = 1;num<= i ; num++){
		System.out.print("* ");
	}
	System.out.println("");
}
```

### 五、方法的定义及使用

> public:该数据成员、成员函数对所有用户开放，所有用户都能直接调用。
>
> private:除了自己的class，谁都无法调用
>
> 方法就是一段可以被重复调用的代码块

前提：方法在主类中定义，并且由主方法直接调用

```java
public static 返回值类型 方法名称([参数类型 变量],……){
	//方法执行代码
    [return 返回值;]
}
```

**说明：**无返回值类型时用void，此时方法中可以利用return来结束调用。

#### 5.1 方法重载

> 当方法名称相同时，而传递的参数类型或个数不同，能够对同一个方法提供更多的选择

```java
public static int sum(int x,int y){
    return x+y;
}
public static double sum(double x,double y){
	return x+y;
}
public static int sum(int x,int y,int z){
    return x+y+z;
}
```

#### 5.2 方法递归调用

> 在方法中调用本方法

- 一定要设置方法递归调用的结束条件
- 每一次调用过程之中要修改传递的参数条件

```java
sum(100);

public static int sum(int num){
    if(num == 1){
        return 1;
    }else{
        return sum(num-1)+num;
    }
}
```
