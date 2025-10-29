# Web Automation — Agoda Flight Booking - NADA AMANATULLAH

VIDEO CI CD JENKINS GIT https://drive.google.com/file/d/1AI6Bsx8eO-X_ZjwPKf44SK6wUx2nBgbO/view?usp=drive_link

Project ini adalah contoh implementasi **Web Automation Framework** berbasis:
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**

## 🚀 Fitur Utama

1. **Page Object Model (POM)**  
   - Setiap halaman web direpresentasikan dalam class terpisah (`HomePage`, `FlightPage`, `CustomerInformationPage`).
   - Menggunakan `@FindBy` dan `PageFactory.initElements()` untuk inisialisasi elemen.

2. **Cucumber BDD**  
   - Menulis test case dalam format natural language (Gherkin) untuk keterbacaan yang tinggi.

3. **TestNG Integration**  
   - Menggunakan `AbstractTestNGCucumberTests` agar mudah diintegrasikan dengan sistem CI/CD.

4. **Hooks Management**  
   - Inisialisasi dan penghentian browser otomatis sebelum & sesudah scenario berjalan.


🚀 Quick Start
### 1. Clone the repository:
```bash
git clone https://github.com/nadamanatullah/finalprojectwebautomation.git
```

### 2. Build the project:
```bash
mvn clean install
```

### 3. Run the tests:
```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml

## 🛠️ How to Run the Tests

This project uses **Maven** for build automation and test execution. Follow the steps below to run the tests.

### 1. Run Tests with Maven

To execute the tests using Maven, use the following command:

```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```