class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def __str__(self):
        return f"{self.manufacturer} {self.model}"

    def accelerate(self):
        print(f"{self} has started moving")

    def stop(self):
        print(f"{self} has stopped moving")

# Creating car instances
car1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

# Using methods
car1.accelerate()
car1.stop()
car2.accelerate()
car3.stop()
