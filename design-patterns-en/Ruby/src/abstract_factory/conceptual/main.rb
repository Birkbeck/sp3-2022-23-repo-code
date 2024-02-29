# Abstract Factory Design Pattern
#
# Intent: Lets you produce families of related objects without specifying their
# concrete classes.

# The Abstract Factory interface declares a set of methods that return different
# abstract products. These products are called a family and are related by a
# high-level theme or concept. Products of one family are usually able to
# collaborate among themselves. A family of products may have several variants,
# but the products of one variant are incompatible with products of another.
class AbstractFactory
  # @abstract
  def create_product_a
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # @abstract
  def create_product_b
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# Concrete Factories produce a family of products that belong to a single
# variant. The factory guarantees that resulting products are compatible. Note
# that signatures of the Concrete Factory's methods return an abstract product,
# while inside the method a concrete product is instantiated.
class ConcreteFactory1 < AbstractFactory
  def create_product_a
    ConcreteProductA1.new
  end

  def create_product_b
    ConcreteProductB1.new
  end
end

# Each Concrete Factory has a corresponding product variant.
class ConcreteFactory2 < AbstractFactory
  def create_product_a
    ConcreteProductA2.new
  end

  def create_product_b
    ConcreteProductB2.new
  end
end

# Each distinct product of a product family should have a base interface. All
# variants of the product must implement this interface.
class AbstractProductA
  # @abstract
  #
  # @return [String]
  def useful_function_a
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# Concrete Products are created by corresponding Concrete Factories.
class ConcreteProductA1 < AbstractProductA
  def useful_function_a
    'The result of the product A1.'
  end
end

class ConcreteProductA2 < AbstractProductA
  def useful_function_a
    'The result of the product A2.'
  end
end

# Here's the the base interface of another product. All products can interact
# with each other, but proper interaction is possible only between products of
# the same concrete variant.
class AbstractProductB
  # Product B is able to do its own thing...
  def useful_function_b
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # ...but it also can collaborate with the ProductA.
  #
  # The Abstract Factory makes sure that all products it creates are of the same
  # variant and thus, compatible.
  def another_useful_function_b(_collaborator)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# Concrete Products are created by corresponding Concrete Factories.
class ConcreteProductB1 < AbstractProductB
  # @return [String]
  def useful_function_b
    'The result of the product B1.'
  end

  # The variant, Product B1, is only able to work correctly with the variant,
  # Product A1. Nevertheless, it accepts any instance of AbstractProductA as an
  # argument.
  def another_useful_function_b(collaborator)
    result = collaborator.useful_function_a
    "The result of the B1 collaborating with the (#{result})"
  end
end

class ConcreteProductB2 < AbstractProductB
  # @return [String]
  def useful_function_b
    'The result of the product B2.'
  end

  # The variant, Product B2, is only able to work correctly with the variant,
  # Product A2. Nevertheless, it accepts any instance of AbstractProductA as an
  # argument.
  def another_useful_function_b(collaborator)
    result = collaborator.useful_function_a
    "The result of the B2 collaborating with the (#{result})"
  end
end

# The client code works with factories and products only through abstract types:
# AbstractFactory and AbstractProduct. This lets you pass any factory or product
# subclass to the client code without breaking it.
def client_code(factory)
  product_a = factory.create_product_a
  product_b = factory.create_product_b

  puts product_b.useful_function_b.to_s
  puts product_b.another_useful_function_b(product_a).to_s
end

# The client code can work with any concrete factory class.
puts 'Client: Testing client code with the first factory type:'
client_code(ConcreteFactory1.new)

puts "\n"

puts 'Client: Testing the same client code with the second factory type:'
client_code(ConcreteFactory2.new)
