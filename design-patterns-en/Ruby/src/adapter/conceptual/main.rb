# Adapter Design Pattern
#
# Intent: Provides a unified interface that allows objects with incompatible
# interfaces to collaborate.

# The Target defines the domain-specific interface used by the client code.
class Target
  # @return [String]
  def request
    'Target: The default target\'s behavior.'
  end
end

# The Adaptee contains some useful behavior, but its interface is incompatible
# with the existing client code. The Adaptee needs some adaptation before the
# client code can use it.
class Adaptee
  # @return [String]
  def specific_request
    '.eetpadA eht fo roivaheb laicepS'
  end
end

# The Adapter makes the Adaptee's interface compatible with the Target's
# interface.
class Adapter < Target
  # @param [Adaptee] adaptee
  def initialize(adaptee)
    @adaptee = adaptee
  end

  def request
    "Adapter: (TRANSLATED) #{@adaptee.specific_request.reverse!}"
  end
end

# The client code supports all classes that follow the Target interface.
def client_code(target)
  print target.request
end

puts 'Client: I can work just fine with the Target objects:'
target = Target.new
client_code(target)
puts "\n\n"

adaptee = Adaptee.new
puts 'Client: The Adaptee class has a weird interface. See, I don\'t understand it:'
puts "Adaptee: #{adaptee.specific_request}"
puts "\n"

puts 'Client: But I can work with it via the Adapter:'
adapter = Adapter.new(adaptee)
client_code(adapter)
