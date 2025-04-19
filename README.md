# Lutemons Game

## 📖 Description
This android project allows users to create and collect lutemons with different attributes. Users can train them and control them in battle. The game supports saving/loading Lutemon data and visualizes each type of Lutemon with a unique image.

## 🧩 Features
- Lutemon Management:
   * Users can create different types of Lutemons with a unique image. 
   * Newly created Lutemons are placed in home with a RecyclerView.
   * Users can move selected Lutemons to training areas or battle arenas. Multiple lutemons can be trained at te same time. Only 2 lutemons can participate in a battle.
- Training System
   * Users can select multiple lutemons to training area. They are displayed with a RecyclerView.
   * Lutemons gain experience points when trained via a button.
   * Experience increases attack power while attack others while the attribute attack remains.
- Turn-Based Battle System
   * Users can select two Lutemons to battle. They are displayed with a RecyclerView.
   * Battles follow a turn-based system:
      1. One Lutemon attacks, the other defends.
      2. The battle can be controled by the user via a next_turn button until one Lutemon’s health drops to zero.
      3. The winner gains an experience point.
      4. The loser will not be removed from the game but lose all the experience.
   * Attack power is also affected by some random factors.
- Lutemon Recovery
   * When a Lutemon returns home, its health is fully restored but experience points remain except for those who died during the battle.
- Data Storage & Loading
   * All Lutemons will be automatically saved to a file.
   * All Lutemons will be loaded in Home page. 

## 🧑‍🤝‍🧑 Team Members & Responsibilities
| Name        | Role/Responsibility                                               |
|-------------|-------------------------------------------------------------------|
| Iro Blanke  | Lutemon classes, Home, MainActivity, Create Lutemons, UI design   |
| Jie Chang   | app structure, Battle, Training, Storage, data storage&loading    |

## 🧱 Class Diagram
![Class Diagram](./Lutemon_classes.png)

## 🧱 Classes included in the diagram:
- `Lutemon`: Represents a Lutemon with attributes like attack, defense, color, health, image and experience. Attack and Defense methods are declared in this class. Child classes override reset methods with different default values. 
- `Storage`: Handles storing and loading of Lutemons. All lutemons and their locations are managed in this class.
- `BattleField`: Contains logic for battling two Lutemons.

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/project-name.git
2. Sync Gradle and run app
3. Lutemons will be loaded.
