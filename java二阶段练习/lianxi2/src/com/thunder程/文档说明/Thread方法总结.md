# Thread 常见成员方法 - 知识点总结

> 来源：黑马程序员  
> 整理日期：2026-08-10  
> 对应代码：`ThreadCommonMethods.java`

---

## 方法速查表

| 方法 | 类型 | 作用 | 是否抛异常 |
|------|------|------|-----------|
| `getName()` | 实例方法 | 返回线程名称 | 否 |
| `setName(String)` | 实例方法 | 设置线程名称 | 否 |
| `currentThread()` | 静态方法 | 获取当前线程对象 | 否 |
| **`sleep(long)`** | 静态方法 | 线程休眠指定毫秒 | **是** |
| `yield()` | 静态方法 | 礼让线程，让出CPU | 否 |
| **`join()`** | 实例方法 | 等待线程执行完毕 | **是** |
| `setPriority(int)` | 实例方法 | 设置优先级(1-10) | 否 |
| `getPriority()` | 实例方法 | 获取优先级 | 否 |
| `setDaemon(boolean)` | 实例方法 | 设为守护线程 | 否 |
| `isAlive()` | 实例方法 | 判断线程是否存活 | 否 |
| `interrupt()` | 实例方法 | 中断线程 | 否 |
| `getId()` | 实例方法 | 获取线程唯一ID | 否 |

---

## 重点方法详解

### 1. sleep(long millis) ⭐⭐⭐
```java
Thread.sleep(1000); // 休眠1秒
```
- 休眠期间**持有锁**（不释放同步锁）
- 必须用 `try-catch` 处理 `InterruptedException`
- 是静态方法，操作当前线程
- 休眠结束进入就绪状态，不是直接运行

### 2. join() ⭐⭐
```java
thread.join();           // 等待thread执行完毕
thread.join(1000);       // 最多等1秒
```
- 常用于等待某个线程完成后继续
- 必须用 `try-catch` 处理 `InterruptedException`
- 是实例方法，调用的是"另一个线程"的join

### 3. setDaemon() ⭐⭐
```java
t.setDaemon(true);  // 必须在start()之前！
t.start();
```
- 守护线程随主线程结束而结束
- ⚠️ 必须在 `start()` 之前设置，否则抛 `IllegalThreadStateException`
- 典型例子：垃圾回收线程(GC)

### 4. yield()
```java
Thread.yield();
```
- 当前线程从运行态 → 就绪态
- 不释放锁
- 只是"提示"，不保证一定让出
- 同优先级或更高优先级的线程可能接着执行

---

## 易混淆对比

### sleep() vs wait()
| | sleep() | wait() |
|---|---|---|
| 是否释放锁 | ❌ 不释放 | ✅ 释放 |
| 使用位置 | 任意 | 必须在 synchronized 内 |
| 所属类 | Thread | Object |
| 唤醒方式 | 自动/时间到 | 手动 notify/notifyAll |

### start() vs run()
| | start() | run() |
|---|---|---|
| 效果 | 新开线程执行 | 普通方法调用 |
| 能否多次调用 | ❌ 只能一次 | ✅ 可以多次 |

### yield() vs sleep()
| | yield() | sleep() |
|---|---|---|
| 是否释放锁 | ❌ 不释放 | ❌ 不释放 |
| 是否强制 | 只是提示 | 强制休眠指定时间 |
| 进入状态 | 就绪 | 计时等待 |

---

## 静态方法 vs 实例方法

**静态方法**（用 `Thread.方法名()` 调用）：
- `currentThread()` - 获取当前线程
- `sleep(long)` - 休眠
- `yield()` - 礼让

**实例方法**（用 `对象.方法名()` 调用）：
- `getName()` / `setName()` - 名称
- `join()` - 等待
- `setPriority()` / `getPriority()` - 优先级
- `setDaemon()` - 守护
- `isAlive()` - 存活判断
- `interrupt()` - 中断

---

## 速记口诀

> **getName/setName** 读写名字  
> **currentThread** 谁执行我就是谁  
> **sleep** 睡一会，毫秒为单位  
> **yield** 让一让，不强制  
> **join** 你等我，你先跑完  
> **setDaemon** 主死我死  
> **interrupt** 中断不是停止，是发信号  

---

## 批注区

### 自己理解的补充：
> （此处留白，可写自己的笔记）

### 遇到的问题：
> （记录学习过程中遇到的坑）

### 记忆技巧：
> （写下帮助自己记忆的方法）

---

*对应可运行代码：`ThreadCommonMethods.java`*
