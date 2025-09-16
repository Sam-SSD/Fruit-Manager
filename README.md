# 🍎 Fruit Manager

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
![Version](https://img.shields.io/badge/Version-1.0.0-green.svg?style=for-the-badge)

*A comprehensive and elegant fruit management system built with Java*

[Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Architecture](#-architecture) • [Contributing](#-contributing)

</div>

---

## 📋 Overview

**Fruit Manager** is a sophisticated Java application designed to manage and analyze fruit collections with an intuitive graphical user interface. The application provides comprehensive functionality for adding, updating, searching, and comparing fruits, along with detailed statistical analysis capabilities.

Whether you're managing inventory for a grocery store, tracking nutritional information, or simply organizing your fruit collection, Fruit Manager offers a clean, professional solution with a focus on usability and data integrity.

## ✨ Features

### 🔧 Core Functionality
- **Add Fruits**: Register new fruits with detailed attributes (name, weight, color, edibility, calories)
- **Update Fruits**: Modify existing fruit information with granular control over individual attributes
- **Delete Fruits**: Remove fruits from your collection with confirmation dialogs
- **Search & Filter**: Find fruits by name with intelligent partial matching
- **Duplicate Detection**: Smart handling of duplicate fruit names with user confirmation

### 📊 Advanced Analysis
- **Fruit Comparison**: Side-by-side comparison of any two fruits with detailed metrics
- **Statistics Dashboard**: Comprehensive statistics including:
  - Total collection size
  - Average weight and calories
  - Healthy vs. unhealthy fruit ratios
  - Edible fruit percentage
  - Weight and calorie distributions

### 🎨 User Experience
- **Intuitive GUI**: Clean, professional interface with dialog-based interactions
- **Smart Formatting**: Beautiful display formatting for all fruit information
- **Pre-loaded Examples**: Comes with sample fruits (Apple, Avocado, Strawberry, Watermelon, Kiwi)
- **Input Validation**: Robust validation for all user inputs with helpful error messages
- **Confirmation Dialogs**: Safe operations with confirmation prompts for destructive actions

## 🚀 Installation

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/Sam-SSD/Fruit-Manager.git
   cd Fruit-Manager
   ```

2. **Compile the application**
   ```bash
   # Navigate to the src directory
   cd src
   
   # Compile all Java files
   javac *.java */*.java
   ```

3. **Run the application**
   ```bash
   java Main
   ```

## 📖 Usage

### Getting Started

1. **Launch the application** by running `java Main`
2. **Welcome screen** will appear with the main menu
3. **Choose from the following options**:

```
🍎 FRUIT MANAGEMENT SYSTEM 🍎
================================
1. Add fruits
2. Show all fruits
3. Search fruit by name
4. Compare fruits
5. Show statistics
6. Update fruit
7. Delete fruit
0. Exit
```

### Example Operations

#### Adding a New Fruit
```
1. Select "Add fruits" from the main menu
2. Enter the number of fruits to add
3. For each fruit, provide:
   - Name (e.g., "Mango")
   - Weight in grams (e.g., 300)
   - Color (e.g., "Yellow")
   - Edibility (Yes/No)
   - Calories per 100g (e.g., 60)
```

#### Comparing Fruits
```
1. Select "Compare fruits" from the main menu
2. Choose the first fruit from the dropdown
3. Choose the second fruit from the dropdown
4. View detailed comparison including:
   - Weight difference
   - Calorie comparison
   - Health assessment
   - Physical characteristics
```

#### Viewing Statistics
The statistics feature provides insights such as:
- **Collection Overview**: Total fruits, average metrics
- **Health Analysis**: Percentage of healthy fruits (< 100 calories/100g)
- **Weight Distribution**: Lightest and heaviest fruits
- **Edibility Stats**: Ratio of edible to non-edible fruits

## 🏗️ Architecture

The application follows a clean **Model-View-Controller (MVC)** architecture pattern:

### 📁 Project Structure
```
src/
├── Main.java                    # Application entry point
├── constants/
│   ├── FruitConstants.java      # Application constants
│   └── UIConstants.java         # UI-related constants
├── controller/
│   └── FruitController.java     # Main application controller
├── factory/
│   └── FruitFactory.java        # Factory for creating example fruits
├── interfaces/
│   ├── IFruitManager.java       # Fruit management interface
│   └── IUserInterface.java      # UI interface
├── model/
│   └── Fruit.java               # Fruit data model
├── service/
│   ├── FruitManager.java        # Business logic for fruit operations
│   └── UserInterface.java       # GUI implementation
└── util/
    └── FruitDisplayFormatter.java # Formatting utilities
```

### 🔧 Key Components

#### **Model Layer**
- **`Fruit`**: Core data model with attributes and business logic methods
- **Constants**: Centralized configuration for thresholds and ratios

#### **Service Layer**
- **`FruitManager`**: Implements business logic for CRUD operations and statistics
- **`UserInterface`**: Handles all GUI interactions and user input validation

#### **Controller Layer**
- **`FruitController`**: Orchestrates the application flow and coordinates between services

#### **Utilities**
- **`FruitDisplayFormatter`**: Provides elegant formatting for fruit information display
- **`FruitFactory`**: Creates pre-configured example fruits for demonstration

### 🎯 Design Patterns Used
- **MVC Pattern**: Clear separation of concerns
- **Factory Pattern**: For creating example fruits
- **Interface Segregation**: Separate interfaces for different responsibilities
- **Single Responsibility**: Each class has a focused purpose

## 🧪 Sample Data

The application comes pre-loaded with the following example fruits:

| Fruit | Weight (g) | Color | Edible | Calories/100g |
|-------|------------|-------|--------|---------------|
| Apple | 150 | Red | ✅ | 52 |
| Avocado | 200 | Green | ✅ | 160 |
| Strawberry | 15 | Red | ✅ | 32 |
| Watermelon | 4000 | Green | ✅ | 30 |
| Kiwi | 70 | Brown | ✅ | 61 |

## 🛠️ Development

### Code Style
- **Clean Code**: Follows Java best practices and naming conventions
- **Documentation**: Comprehensive JavaDoc comments for all public methods
- **Error Handling**: Robust exception handling with user-friendly messages
- **Validation**: Input validation for all user interactions

### Future Enhancements
- [ ] **Data Persistence**: Save/load fruit collections to/from files
- [ ] **Import/Export**: CSV and JSON support
- [ ] **Advanced Search**: Filter by multiple criteria
- [ ] **Nutritional Database**: Integration with external nutrition APIs
- [ ] **Graphical Charts**: Visual representation of statistics
- [ ] **Internationalization**: Multi-language support

## 🤝 Contributing

We welcome contributions! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Contribution Guidelines
- Follow existing code style and patterns
- Add tests for new functionality
- Update documentation as needed
- Ensure all existing tests pass

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Sam-SSD**
- GitHub: [@Sam-SSD](https://github.com/Sam-SSD)
- Project Link: [https://github.com/Sam-SSD/Fruit-Manager](https://github.com/Sam-SSD/Fruit-Manager)

---

<div align="center">

**⭐ If you found this project helpful, please give it a star! ⭐**

*Made with ❤️ and ☕ by Sam-SSD*

</div>