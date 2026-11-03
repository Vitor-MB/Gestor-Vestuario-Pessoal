# Personal Wardrobe Manager

Personal Wardrobe Manager is a Java application for organizing a personal clothing collection. It provides a graphical interface for managing wardrobe items through CRUD operations and creating looks from the available pieces.

## Architecture and implementation

The project is organized into Java packages that separate the wardrobe domain, the graphical interface, and custom exceptions:

- `br.ufc.tp.vestuario.itens` contains the abstract `Item` base class and specialized item types, such as clothing, shoes, and accessories. Enums and interfaces define shared properties and capabilities.
- `br.ufc.tp.vestuario` contains the wardrobe and look models, along with in-memory collections that manage items, looks, and loan records.
- `br.ufc.tp.vestuario.itens.main` contains the Swing windows and event listeners that form the virtual interface and connect user actions to the application model.
- `br.ufc.tp.vestuario.excecoes` contains domain-specific exceptions for invalid operations and data, such as duplicate or missing items and invalid looks.

The application is built around object-oriented design: item categories extend a common abstract class, while interfaces represent behaviors that only apply to certain items, such as being washable or lendable. The interface collects user input and invokes model operations; validation and exceptional cases are handled with custom exceptions. Looks combine selected wardrobe items and can record usage events, which also update the usage counts of their pieces. The current collections are held in memory using Java data structures such as maps and lists.

This project was created for the **Programming Techniques I (Técnicas de Programação I)** course.
