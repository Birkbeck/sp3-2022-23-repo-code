# Composite Design Pattern
#
# Intent: Lets you compose objects into tree structures and then work with these
# structures as if they were individual objects.

# The base Component class declares common operations for both simple and
# complex objects of a composition.
class Component
  # @return [Component]
  def parent
    @parent
  end

  # Optionally, the base Component can declare an interface for setting and
  # accessing a parent of the component in a tree structure. It can also provide
  # some default implementation for these methods.
  def parent=(parent)
    @parent = parent
  end

  # In some cases, it would be beneficial to define the child-management
  # operations right in the base Component class. This way, you won't need to
  # expose any concrete component classes to the client code, even during the
  # object tree assembly. The downside is that these methods will be empty for
  # the leaf-level components.
  def add(component)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # @abstract
  #
  # @param [Component] component
  def remove(component)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # You can provide a method that lets the client code figure out whether a
  # component can bear children.
  def composite?
    false
  end

  # The base Component may implement some default behavior or leave it to
  # concrete classes (by declaring the method containing the behavior as
  # "abstract").
  def operation
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# The Leaf class represents the end objects of a composition. A leaf can't have
# any children.
#
# Usually, it's the Leaf objects that do the actual work, whereas Composite
# objects only delegate to their sub-components.
class Leaf < Component
  # return [String]
  def operation
    'Leaf'
  end
end

# The Composite class represents the complex components that may have children.
# Usually, the Composite objects delegate the actual work to their children and
# then "sum-up" the result.
class Composite < Component
  def initialize
    @children = []
  end

  # A composite object can add or remove other components (both simple or
  # complex) to or from its child list.

  # @param [Component] component
  def add(component)
    @children.append(component)
    component.parent = self
  end

  # @param [Component] component
  def remove(component)
    @children.remove(component)
    component.parent = nil
  end

  # @return [Boolean]
  def composite?
    true
  end

  # The Composite executes its primary logic in a particular way. It traverses
  # recursively through all its children, collecting and summing their results.
  # Since the composite's children pass these calls to their children and so
  # forth, the whole object tree is traversed as a result.
  def operation
    results = []
    @children.each { |child| results.append(child.operation) }
    "Branch(#{results.join('+')})"
  end
end

# The client code works with all of the components via the base interface.
def client_code(component)
  puts "RESULT: #{component.operation}"
end

# Thanks to the fact that the child-management operations are declared in the
# base Component class, the client code can work with any component, simple or
# complex, without depending on their concrete classes.
def client_code2(component1, component2)
  component1.add(component2) if component1.composite?

  print "RESULT: #{component1.operation}"
end

# This way the client code can support the simple leaf components...
simple = Leaf.new
puts 'Client: I\'ve got a simple component:'
client_code(simple)
puts "\n"

# ...as well as the complex composites.
tree = Composite.new

branch1 = Composite.new
branch1.add(Leaf.new)
branch1.add(Leaf.new)

branch2 = Composite.new
branch2.add(Leaf.new)

tree.add(branch1)
tree.add(branch2)

puts 'Client: Now I\'ve got a composite tree:'
client_code(tree)
puts "\n"

puts 'Client: I don\'t need to check the components classes even when managing the tree:'
client_code2(tree, simple)
