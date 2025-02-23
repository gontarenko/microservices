Todos:
- [ ]  Добавь в customer-service:
- Две новые сущности:
  - Address – для хранения адресов клиентов. (или точка RetailPoint/Point)
    - Поля: id, customerId, street, city, state, postalCode, country.
      Связь: Один клиент может иметь несколько адресов (One-to-Many).
    - Добавить возможность создания/удаления/редактирования через контроллер
  - Order – для хранения заказов клиентов.
    - Поля: id, customerId, orderDate, status (пока что enum с одним статусом NEW), totalAmount, pickupPoint, deliveryPoint.
    - Связь: Один клиент может делать несколько заказов (One-to-Many).
    - Добавить возможность создания/удаления/редактирования через контроллер
- [ ] add Unit + IT tests (testcontainers)

 
Почитать:
