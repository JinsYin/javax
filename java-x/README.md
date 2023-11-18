# Java-X

**Java-X** 即 Java Extension，意为 Java 标准库的扩展。

## Usage

```bash

```

## Setup

1. 设置 Maven（Unix/Linux），指定 `仓库 ID`、`账号` 和 `密码`：

```bash
$ cat ~/.m2/settings.xml
```

```xml
<settings>
  <servers>
    <server>
      <id>easipass-release</id>
      <username>rqyin</username>
      <password>easipass</password>
    </server>
    <server>
      <id>easipass-snapshot</id>
      <username>rqyin</username>
      <password>easipass</password>
    </server>
  </servers>
</settings>
```

2. 配置 `pom.xml`，指定发布地址：

```xml
<project>
  <distributionManagement>
    <repository>
      <id>easipass-release</id>
      <url>http://192.168.118.127:8081/repository/easipass/</url>
    </repository>
    <snapshotRepository>
      <id>easipass-snapshot</id>
      <url>http://192.168.118.127:8081/repository/easipass/</url>
    </snapshotRepository>
  </distributionManagement>
</project>
```

3. 部署到私有仓库：

```bash
$ mvn clean deploy
```