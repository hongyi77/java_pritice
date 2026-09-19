# java_pritice

Java 学习笔记与练习集，涵盖基础语法、多线程、IO 流、Git 版本控制及算法题解。

## 项目结构

```
java_pritice/
├── java一阶段练习/              # Java 基础语法专项练习
├── java二阶段练习/               # 进阶主题：Git、多线程、IO、Hutool
│   ├── Git核心基础用法.md        # Git 实战教程
│   ├── lianxi2/                  # 综合练习代码
│   │   └── src/com/thunder程/    # 多线程/线程安全/线程池等练习
│   ├── 知识总结/                 # IO、线程模块知识点总结
│   └── hutool使用说明.md         # Hutool 工具库用法参考
└── data_pritice/                 # 算法题解
    └── 正则表达式匹配_详解.md      # LeetCode #10 DP 详解
```

---

## 📚 java一阶段练习

Java 基础语法专项练习，通过大量小项目掌握核心概念：

| 分类 | 说明 |
| --- | --- |
| 数据类型与变量 | 基本类型、类型转换、运算符 |
| 流程控制 | if / switch / for / while / break / continue |
| 数组与字符串 | 数组操作、字符串处理、StringBuffer/StringBuilder |
| 面向对象 | 类与对象、继承、多态、封装、接口 |
| 异常处理 | try-catch、自定义异常、throws |
| Map 集合 | HashMap、遍历、常见用法 |
| 小游戏 | 排序、吃豆豆、贪吃蛇、随机数等趣味练习 |

源码位于 `java一阶段练习/代码练习源文件/Ball/src/`，按功能模块分包组织。

---

## 📚 java二阶段练习

进阶主题练习，包含六个核心模块。

### 1. Git 核心基础用法

[Git核心基础用法.md](java二阶段练习/Git核心基础用法.md) — 面向初学者的 Git 实战教程，覆盖日常开发 90% 的场景：

- 核心概念：工作区 → 暂存区 → 仓库的流转
- 初始化与首次提交
- 日常循环：`status` / `diff` / `add` / `commit` / `log`
- 分支管理：创建、切换、合并、冲突解决
- 远程协作：clone / pull / push 工作流
- 撤销操作：`restore` / `reset` 安全用法
- 命令速查表 + 常见问题清单

### 2. 多线程并发编程

#### 线程基础与生命周期

| 文档 | 内容 |
| --- | --- |
| [线程学习总结.txt](java二阶段练习/知识总结/线程学习总结.txt) | 零基础版线程教程：创建方式、生命周期、状态图、常见误区 |
| [Thread方法总结.md](java二阶段练习/lianxi2/src/com/thunder程/文档说明/Thread方法总结.md) | Thread 类核心方法速查表 + 易混淆对比（sleep/wait/yield） |
| [yield详细理解.md](java二阶段练习/lianxi2/src/com/thunder程/文档说明/yield详细理解.md) | yield() 的行为、使用场景与注意事项 |

#### 线程安全与同步

| 练习 | 主题 |
| --- | --- |
| `thunder_safe/` | synchronized 方法锁、代码块锁、对象锁对比 |
| `thunder_instance/` | 线程实例化方式（继承 Thread / 实现 Runnable） |
| `thread_02/` | wait/notify、Volatile 可见性、线程池基础 |
| `thread_03/` | 阻塞队列（生产者-消费者模式） |
| `thread_04/` | CountDownLatch / CyclicBarrier / Semaphore / ThreadLocal |
| `Thread_all_pritice/pritice1~6` | 电影票、送礼、数数、抢红包、抽奖、最大需求等经典场景 |

#### 进程与 Runtime

- `Runtime_pritice/` — Runtime 类用法、进程间通信

### 3. IO 流

| 文档 | 内容 |
| --- | --- |
| [IO学习总结.txt](java二阶段练习/知识总结/IO学习总结.txt) | 从字节流到 NIO 的完整知识体系，含面试考点（BIO vs NIO、Buffer 属性、序列化、Files.walkFileTree） |

练习代码覆盖：

| 模块 | 内容 |
| --- | --- |
| `file_prictice/filedemon*.java` | 字节流读写、缓冲区优化、性能测量 |
| `io_pritice/kaobeiio*.java` | 文件拷贝（不同实现方式对比） |
| `io_pritice/iofiledemon*.java` | 字符流、缓冲流、转换流 |
| `io_pritice/xvlieliu/` | 序列化与反序列化（ObjectInputStream/ObjectOutputStream） |
| `io_pritice/status/` | 压缩流（ZipInputStream/ZipOutputStream） |
| `allpritice/io/` | 网络爬虫 + IO 综合练习 |

### 4. Hutool 工具库

[Hutool 5.8.47 用法说明.md](java二阶段练习/lianxi2/hutool使用说明.md) — 项目级工具库使用指南：

- 核心模块速查表（core / http / json / crypto / date / id）
- HTTP 请求（爬虫场景）、文件操作、字符串处理、JSON 解析
- 本项目实战案例：`hutoolpritice.java`（爬取古诗网页并写入文件）

### 5. 异常处理

- `com/异常/` — 自定义异常（nameException / ageException）、Throwable 层级演示

### 6. 补充练习

- `com/补充/` — Data / Data1 / Data2 综合练习

---

## 📚 data_pritice

算法题解与数据结构练习。

### LeetCode #10 — 正则表达式匹配

[data_pritice/正则表达式匹配_详解.md](data_pritice/正则表达式匹配_详解.md) — 超详解文章，从题目理解到动态规划填表过程逐步推导：

- 题目理解与示例分析
- 为什么用动态规划
- 二维 DP 数组定义与初始化
- 状态转移方程推导（普通字符 vs `*` 量词）
- 完整填表过程演示（s="ab", p="a*b"）
- Java 实现代码
- 易错点总结 + 自测题

---

## 学习路线建议

```
一阶段（基础语法） → 二阶段（进阶主题） → data_pritice（算法）
变量/循环/类       Git + 多线程 + IO  + Hutool   正则/动态规划
```

1. **一阶段**：把 Ball 目录下的所有练习跑通，确保基础语法扎实
2. **二阶段**：先读 Git 文档（日常查阅），再逐模块练习多线程和 IO
3. **data_pritice**：题解含完整推导过程，适合面试复习

## 许可证

MIT
