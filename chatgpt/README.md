# Java Console App Example (Maven + OpenJDK)

โปรเจกต์ตัวอย่างนี้อยู่ในโฟลเดอร์ `chatgpt` และใช้ package ตามที่ต้องการ:

- `com.biz.app.app3`

## โครงสร้าง

- `pom.xml` — Maven config
- `src/main/java/com/biz/app/app3/Main.java` — โปรแกรมหลัก
- `.vscode/launch.json` — ปุ่ม Run/Debug ใน VS Code
- `.vscode/tasks.json` — Build/Run ด้วย Maven
- `.vscode/settings.json` — ตั้งค่า OpenJDK runtime ตัวอย่าง (Java 17)

## วิธีรัน

```bash
cd chatgpt
mvn clean package
mvn exec:java
```

## รันใน VS Code

1. เปิดโฟลเดอร์โปรเจกต์ `/workspace/javadev`
2. ติดตั้ง Extension Pack for Java
3. ถ้า path JDK ใน `.vscode/settings.json` ไม่ตรงเครื่องคุณ ให้แก้ `java.configuration.runtimes[].path`
4. กด Run ที่ configuration ชื่อ **Run Main (app3)**

## แสดง path ใน folder `chatgpt/`

ใช้คำสั่งนี้เพื่อแสดง path ของไฟล์ทั้งหมดในโฟลเดอร์ `chatgpt/`:

```bash
find chatgpt -type f | sort
```
