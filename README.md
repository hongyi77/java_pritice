# java_pritice

Java 学习笔记与练习集，涵盖基础语法、多线程、IO 流、Git 版本控制及算法题解。

## 项目结构

```
java_pritice/
├── java一阶段练习/        # Java 基础语法练习（变量、循环、数组、面向对象等）
├── java二阶段练习/        # 进阶主题：Git、多线程、IO 流
│   ├── Git核心基础用法.md  # Git 常用命令速查与实战指南
│   ├── lianxi2/           # 多线程练习代码
│   │   └── src/com/thunder程/
│   │       ├── 文档说明/
│   │       │   ├── Thread方法总结.md
│   │       │   ├── yield详细理解.md
│   │       │   └── 线程学习总结.txt
│   │       └── Thread_all_pritice/pritice4/
│   │           └── 抢红包问题总结.md
│   └── 知识总结/          # IO 流、线程等模块总结
│       ├── IO学习总结.txt
│       └── 线程学习总结.txt
└── data_pritice/          # 算法与数据结构练习
    └── 正则表达式匹配_详解.md  # LeetCode #10 超详解
```

---

## 📚 java一阶段练习

Java 基础语法专项练习，内容包括：

- 数据类型与变量
- 运算符与表达式
- 流程控制（if / switch / for / while）
- 数组与字符串
- 面向对象编程（类、继承、多态、接口）
- 异常处理

---

## 📚 java二阶段练习

进阶主题练习，包含 Git 版本控制与多线程并发编程。

### Git 核心基础用法

面向初学者的 Git 实战教程，覆盖日常开发 90% 的场景：

- 核心概念：工作区、暂存区、仓库的流转关系
- 初始化与首次提交
- 日常循环：`status` / `diff` / `add` / `commit` / `log`
- 分支管理：创建、切换、合并、冲突解决
- 远程协作：clone / pull / push 工作流
- 撤销操作：`restore` / `reset` 安全用法
- 命令速查表 + 常见问题清单

参见 [Git核心基础用法.md](java二阶段练习/Git核心基础用法.md)

### 多线程练习

包含以下练习与总结：

| 文件 | 内容 |
| --- | --- |
| [Thread方法总结.md](java二阶段练习/lianxi2/src/com/thunder程/文档说明/Thread方法总结.md) | Thread 类核心方法归纳 |
| [yield详细理解.md](java二阶段练习/lianxi2/src/com/thunder程/文档说明/yield详细理解.md) | yield() 方法的行为与使用场景 |
| [抢红包问题总结.md](java二阶段练习/lianxi2/src/com/thunder程/Thread_all_pritice/pritice4/抢红包问题总结.md) | 多线程抢红包的同步方案设计 |

### IO 流

- [IO学习总结.txt](java二阶段练习/知识总结/IO学习总结.txt)

---

## 📚 data_pritice

算法题解与数据结构练习。

### LeetCode #10 — 正则表达式匹配

超详解文章，从题目理解到动态规划填表过程逐步推导：

- 题目理解与示例分析
- 为什么用动态规划
- 二维 DP 数组定义与初始化
- 状态转移方程推导（普通字符 vs `*` 量词）
- 完整填表过程演示（s="ab", p="a*b"）
- Java 实现代码
- 易错点总结 + 自测题

参见 [正则表达式匹配_详解.md](data_pritice/正则表达式匹配_详解.md)

---

## 学习路线建议

```
一阶段（基础） → 二阶段（进阶） → data_pritice（算法）
Java 语法熟练   Git + 多线程   正则/动态规划
```

1. 先把一阶段练习跑通，确保基础语法扎实
2. 二阶段的 Git 文档适合日常查阅，多线程部分重点理解同步机制
3. data_pritice 的题解包含完整推导过程，适合复习和面试准备

## 许可证

MIT
