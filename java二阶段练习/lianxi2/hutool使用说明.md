# Hutool 5.8.47 用法说明

## 一、这个 jar 是什么

`hutool-all-5.8.47.jar` 是 **Hutool 工具库的全量聚合包**。Hutool 是一个 Java 工具类库,把日常开发中常用的小功能(文件操作、网络请求、JSON 解析、加密、日志、日期处理等)封装成静态方法,一行代码就能调用,省去重复造轮子。

> jar 名里的 `all` 表示它把 Hutool 的 **20 个子模块** 打进了同一个 jar,所以叫"全量包"。引入这一个 jar 就等于引入了整个 Hutool。

- **官方文档**: https://hutool.cn/docs
- **当前版本**: 5.8.47
- **构建要求**: Java 1.8+(JDK 8 及以上都能用)

---

## 二、这个 jar 包含哪些模块

顶层包路径为 `cn.hutool.*`,共 20 个模块:

| 包名 | 功能 | 常用入口类 |
| --- | --- | --- |
| `cn.hutool.core` | 核心工具,最常用 | `StrUtil`、`FileUtil`、`DateUtil`、`Convert`、`IdUtil` |
| `cn.hutool.http` | HTTP 请求 | `HttpUtil`、`HttpRequest`、`HttpResponse` |
| `cn.hutool.json` | JSON 解析 | `JSONUtil`、`JSONObject`、`JSONArray` |
| `cn.hutool.crypto` | 加密解密(MD5/AES/RSA) | `SecureUtil`、`DigestUtil` |
| `cn.hutool.db` | 数据库访问 | `Db` |
| `cn.hutool.poi` | Excel/Word 读写 | `ExcelUtil` |
| `cn.hutool.captcha` | 图形验证码 | `CaptchaUtil` |
| `cn.hutool.cron` | 定时任务 | `CronUtil` |
| `cn.hutool.log` | 日志 | `Log`、`LogFactory` |
| `cn.hutool.setting` | 配置文件读取 | `Setting`、`Props` |
| `cn.hutool.dfa` | 敏感词过滤 | `DFAUtil` |
| `cn.hutool.jwt` | JWT 令牌 | `JWTUtil` |
| `cn.hutool.system` | 系统信息 | `SystemUtil` |
| `cn.hutool.socket` | Socket 通信 | `NioServer`、`NioClient` |
| `cn.hutool.aop` | AOP 切面 | `ProxyUtil` |
| `cn.hutool.script` | 脚本引擎(JS 等) | `JavaScriptEngine` |
| `cn.hutool.bloomfilter` | 布隆过滤器 | `BloomFilterUtil` |
| `cn.hutool.cache` | 缓存 | `CacheUtil` |
| `cn.hutool.extra` | 扩展(邮件/模板/SSH/FTP) | `MailUtil`、`Ftp` |
| `cn.hutool.ai` | AI 相关(5.8.x 新增) | — |

**本项目常用**:`core`(文件/字符串)、`http`(网页爬取)、`json`(解析数据)。

---

## 三、在项目里怎么用

### 1. 引入依赖

本项目是 IDEA 工程(非 Maven),jar 放在 `lib/` 目录下,通过 IDEA 手动添加:

1. 菜单 **File → Project Structure** → **Libraries**(或右键 `lib/hutool-all-5.8.47.jar` → **Add as Library**)
2. 项目已配置好,见 `.idea/libraries/hutool_all_5_8_47.xml`

若是 Maven 工程,在 `pom.xml` 里加:

```xml
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.47</version>
</dependency>
```

### 2. 代码里导入使用

```java
import cn.hutool.http.HttpUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
```

---

## 四、常用功能示例

### 1. HTTP 请求(本项目 `hutoolpritice.java` 正在用)

```java
import cn.hutool.http.HttpUtil;

// GET 请求,返回网页源码字符串
String html = HttpUtil.get("https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d");

// 带参数的 GET
String result = HttpUtil.get("https://api.example.com/user?id=1&name=hutool");

// POST 请求
String post = HttpUtil.post("https://api.example.com/login", "username=admin&password=123456");

// 下载文件到本地
HttpUtil.downloadFile("https://example.com/a.zip", "D:/download/a.zip");
```

> 你的 `hutoolpritice.java` 里 `HttpUtil.get(...)` 拿到网页源码后,再用正则提取内容,写进文件——就是"爬虫"的雏形。进阶可用 `HttpRequest` 类控制请求头、Cookie、超时:

```java
String html = HttpRequest.get(url)
        .header("User-Agent", "Mozilla/5.0")   // 模拟浏览器
        .timeout(5000)                          // 5 秒超时
        .execute()
        .body();
```

### 2. 文件操作(`core.io`)

```java
import cn.hutool.core.io.FileUtil;

String path = "D:/githup仓库/java二阶段练习/lianxi2/src/百家姓";

FileUtil.readUtf8String(path);   // 读整个文件为字符串
FileUtil.writeUtf8String("内容", path);  // 写字符串到文件
FileUtil.exist(path);            // 判断文件是否存在
FileUtil.mkdir("D:/newdir");     // 递归创建目录
FileUtil.copy("a.txt", "b.txt", true);  // 复制文件,true=覆盖
FileUtil.del("old.txt");         // 删除文件
```

### 3. 字符串处理(`core.util`)

```java
import cn.hutool.core.util.StrUtil;

StrUtil.isEmpty("");       // true
StrUtil.isBlank("  ");     // true
StrUtil.sub("abcdef", 1, 3);      // 截取 -> "bc"
StrUtil.join(",", "a", "b", "c"); // 拼接 -> "a,b,c"
StrUtil.removePrefix("abc", "a"); // 去前缀 -> "bc"
```

### 4. JSON 解析(`json`)

```java
import cn.hutool.json.JSONUtil;

// 字符串转 JSON 对象
JSONObject obj = JSONUtil.parseObj("{\"name\":\"张三\",\"age\":18}");
obj.getStr("name");   // "张三"
obj.getInt("age");    // 18

// Java 对象转 JSON
String json = JSONUtil.toJsonStr(new Student("张三", 18));

// JSON 转回对象
Student s = JSONUtil.toBean(json, Student.class);
```

### 5. 日期处理(`core.date`)

```java
import cn.hutool.core.date.DateUtil;

String now = DateUtil.now();        // 当前时间 "2026-08-04 21:10:00"
Date d = DateUtil.parse("2026-08-04");   // 字符串转日期
DateUtil.format(d, "yyyy/MM/dd");   // 格式化
DateUtil.dayOfWeek(d);              // 星期几
DateUtil.betweenDay(d, DateUtil.date(), false);  // 相差天数
```

### 6. 唯一 ID(`core.id`)

```java
import cn.hutool.core.util.IdUtil;

IdUtil.fastSimpleUUID();  // 简单 UUID,无横线
IdUtil.simpleUUID();      // 简单 UUID(截断)
IdUtil.getSnowflakeNextIdStr();  // 雪花算法 ID(分布式场景)
```

### 7. 加密(`crypto`)

```java
import cn.hutool.crypto.SecureUtil;

SecureUtil.md5("123456");      // MD5
SecureUtil.sha256("123456");   // SHA-256
SecureUtil.aes("密钥".getBytes());  // AES 加解密
```

### 8. 其他顺手工具

```java
cn.hutool.core.util.RandomUtil.randomInt(1, 100);     // 随机数
cn.hutool.core.util.NumberUtil.add("1.1", "2.2");     // 精确加法
cn.hutool.core.convert.Convert.toInt("123");          // 类型转换
cn.hutool.captcha.CaptchaUtil.createLineCaptcha(200, 100);  // 图形验证码
```

---

## 五、本项目实际用法(对照 `hutoolpritice.java`)

`src/com/allpritice/hutool/hutoolpritice.java` 的流程拆解:

1. `HttpUtil.get(url)` —— 用 Hutool 发 GET 请求,拿到古诗网页的 HTML 源码
2. 用 `java.util.regex` 正则从源码里提取中文短句
3. 用原生 `FileWriter` 把结果写入 `src/百家姓` 文件

可以看到:网络请求这一步已经用 Hutool 简化了;后面的正则和文件写入可以继续用 Hutool 的 `StrUtil`、`FileUtil` 进一步简化。这是练习 Hutool 的典型路径——**用熟了核心模块,大部分重复代码都能一行搞定**。

---

## 六、注意事项

1. **JDK 版本**:Hutool 5.x 需要 **JDK 8+**。
2. **`hutool-all` 是全量包**,生产环境想减小体积可按需引单模块(如 `hutool-http`、`hutool-core`),Maven 下会自动带依赖。
3. **HttpUtil 默认超时**:若不设置,`HttpUtil.get` 可能长时间卡住,爬虫类场景建议设超时或用 `HttpRequest` 控制。
4. **编码**:读写文件默认 UTF-8;处理 GBK 文本时用 `FileUtil.readString(file, CharsetUtil.CHARSET_GBK)`。
5. **IDEA 里看源码/文档**:已配好 `hutool_all_5_8_47_javadoc.xml` 和源码关联,点方法名 `Ctrl+B` 即可跳转。
