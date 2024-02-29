# Decorator Design Pattern
#
# Intent: Lets you attach new behaviors to objects by placing these objects
# inside special wrapper objects that contain the behaviors.

# The base Component interface defines operations that can be altered by
# decorators.
class Component
  # @return [String]
  def operation
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# Concrete Components provide default implementations of the operations. There
# might be several variations of these classes.
class ConcreteComponent < Component
  # @return [String]
  def operation
    'ConcreteComponent'
  end
end

# The base Decorator class follows the same interface as the other components.
# The primary purpose of this class is to define the wrapping interface for all
# concrete decorators. The default implementation of the wrapping code might
# include a field for storing a wrapped component and the means to initialize
# it.
class Decorator < Component
  attr_accessor :component

  # @param [Component] component
  def initialize(component)
    @component = component
  end

  # The Decorator delegates all work to the wrapped component.
  def operation
    @component.operation
  end
end

# Concrete Decorators call the wrapped object and alter its result in some way.
class ConcreteDecoratorA < Decorator
  # Decorators may call parent implementation of the operation, instead of
  # calling the wrapped object directly. This approach simplifies extension of
  # decorator classes.
  def operation
    "ConcreteDecoratorA(#{@component.operation})"
  end
end

# Decorators can execute their behavior either before or after the call to a
# wrapped object.
class ConcreteDecoratorB < Decorator
  # @return [String]
  def operation
    "ConcreteDecoratorB(#{@component.operation})"
  end
end

# The client code works with all objects using the Component interface. This way
# it can stay independent of the concrete classes of components it works with.
def client_code(component)
  # ...

  print "RESULT: #{component.operation}"

  # ...
end

# This way the client code can support both simple components...
simple = ConcreteComponent.new
puts 'Client: I\'ve got a simple component:'
client_code(simple)
puts "\n\n"

# ...as well as decorated ones.
#
# Note how decorators can wrap not only simple components but the other
# decorators as well.
decorator1 = ConcreteDecoratorA.new(simple)
decorator2 = ConcreteDecoratorB.new(decorator1)
puts 'Client: Now I\'ve got a decorated component:'
client_code(decorator2)
