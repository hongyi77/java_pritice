# Git 核心基础用法

> 面向初学者的实战教程，覆盖日常开发 90% 的场景。

## 一、核心概念

Git 是分布式版本控制系统，核心是"快照"思想：每次提交（commit）保存整个项目的一个快照，分支只是指向某个快照的指针。

### 三个区域

| 区域 | 说明 | 对应命令 |
| --- | --- | --- |
| 工作区（Working Directory） | 你磁盘上看到的文件 | 直接编辑 |
| 暂存区（Staging Area） | `git add` 之后、待提交的内容 | `git add` |
| 仓库（Repository） | `git commit` 之后的历史快照 | `git commit` |

理解这张流转图即可：

```
工作区 --git add--> 暂存区 --git commit--> 仓库（历史）
```

## 二、初始化与首次提交

```bash
git init                  # 在当前目录初始化仓库（生成 .git/ 目录）
git add .                 # 把所有改动放入暂存区（. 表示当前目录）
git status                # 查看状态：红色 = 未暂存，绿色 = 已暂存
git commit -m "First commit"   # 提交，-m 后跟提交说明
```

> 提示：提交前先确认 `git config user.name` 和 `git config user.email` 已设置。
> 只在本机设置一次：
> ```bash
> git config --global user.name "你的名字"
> git config --global user.email "你的邮箱"
> ```

## 三、日常循环（改代码 → 提交）

```bash
git status                # 看有哪些改动
git diff                  # 看具体改了哪些行（未暂存的部分）
git diff --staged         # 看已暂存但还没提交的改动
git add 文件名            # 只暂存某个文件
git add .                 # 暂存全部改动
git commit -m "Fix typo in login page"   # 提交
git log --oneline         # 查看提交历史（一行一条，最常用）
```

**工作纪律**：
- 小步提交、一事一提交，不要攒一大堆改动才提交。
- commit message 用简洁英文，动词开头，如 `Add login page`、`Fix null pointer bug`。
- 提交前用 `git status` 和 `git diff` 检查改动是否符合预期。

## 四、分支：并行开发的核心

```bash
git branch                # 列出所有分支，* 表示当前所在分支
git branch feature-x      # 新建分支（不会自动切换）
git checkout -b feature-x # 新建并切换到该分支（最常用）
git switch feature-x      # 新版写法，等价于切换分支

git checkout main         # 切回主分支
git merge feature-x       # 把 feature-x 合并进当前分支
git branch -d feature-x   # 合并完成后删除分支
```

**分支工作流**：
1. 从 `main` 拉出新分支：`git checkout -b feature-xxx`
2. 在分支上开发并多次提交。
3. 完成后切回 `main`，合并：`git merge feature-xxx`。
4. 删除已合并的分支：`git branch -d feature-xxx`。

> 合并时如果两个分支改了同一处代码，会产生冲突。Git 会在冲突文件里标注：
> ```
> <<<<<<< HEAD
> 当前分支的内容
> =======
> 被合并分支的内容
> >>>>>>> feature-x
> ```
> 手动选择保留哪段、删掉 `<<<<<<<`、`=======`、`>>>>>>>` 标记，然后 `git add` + `git commit` 完成冲突解决。

## 五、远程仓库协作（GitHub / GitLab / Gitee）

```bash
git clone <仓库地址>      # 第一次把远程仓库完整拉取到本地
git pull                  # 拉取远程最新改动并合并到当前分支
git push                  # 把本地提交推送到远程
git remote -v             # 查看远程仓库地址
```

**日常协作节奏**：
1. 开工前先 `git pull`，确保基于最新代码。
2. 本地开发、提交。
3. 收工前 `git push` 推送。
4. 第一次推送新分支：`git push -u origin 分支名`（`-u` 记住关联，之后直接 `git push`）。

## 六、撤销操作（初学者最容易用错）

```bash
git restore 文件名          # 丢弃工作区改动，恢复到上次提交的状态
git restore --staged 文件名 # 把文件从暂存区撤回（git add 的反操作）
git reset --soft HEAD~1     # 撤回最近一次提交，改动保留在暂存区
git log --oneline -5        # 撤销前先看历史，确认要撤回哪一条
```

**危险命令，谨慎使用**：
- `git reset --hard`：永久丢弃改动，不可恢复。
- `git push --force`：覆盖远程历史，会破坏协作。
- 不确定时先备份文件或用 `git stash` 暂存改动，不要贸然重置。

## 七、命令速查表

| 场景 | 命令 |
| --- | --- |
| 初始化仓库 | `git init` |
| 查看状态 | `git status` |
| 暂存文件 | `git add 文件名` / `git add .` |
| 提交 | `git commit -m "说明"` |
| 查看历史 | `git log --oneline` |
| 查看改动 | `git diff` |
| 新建并切换分支 | `git checkout -b 分支名` |
| 切换分支 | `git checkout 分支名` / `git switch 分支名` |
| 合并分支 | `git merge 分支名` |
| 拉取远程 | `git pull` |
| 推送远程 | `git push` / `git push -u origin 分支名` |
| 克隆仓库 | `git clone 地址` |
| 丢弃工作区改动 | `git restore 文件名` |
| 撤回暂存 | `git restore --staged 文件名` |
| 图形化看历史 | `git log --graph --oneline --all` |

## 八、常见问题与注意事项

1. **`.gitignore`**：在项目根目录创建 `.gitignore`，写入要忽略的模式，例如 `node_modules/`、`target/`、`*.log`、`.idea/`。提交前先建好，避免把编译产物和 IDE 配置提交进仓库。
2. **不知道下一步做什么**：运行 `git status`，它几乎总会告诉你当前状态和可选操作。
3. **提交错文件**：用 `git restore --staged 文件名` 撤回，而不是删除文件。
4. **误删文件**：`git checkout -- 文件名` 可从上次提交恢复（等同 `git restore 文件名`）。
5. **不要提交敏感信息**：密码、token、密钥绝不入库，已误提交的尽快改密并清理历史。
6. **远程有更新但 push 被拒**：先 `git pull` 合并远程改动，再 `git push`。

## 九、最少掌握清单

**8 条命令覆盖日常 90% 场景**：

```
git init / add / commit / status / log / branch / checkout / push
```

先练熟这 8 条，再逐步掌握 merge、pull、restore、stash 等进阶操作。
