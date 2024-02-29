# Singleton Design Pattern
#
# Intent: Lets you ensure that a class has only one instance, while providing a
# global access point to this instance.

# The Singleton class defines the `intance` method that lets clients access the
# unique singleton instance.
class Singleton
  attr_reader :value

  @instance_mutex = Mutex.new

  private_class_method :new

  def initialize(value)
    @value = value
  end

  # The static method that controls the access to the singleton instance.
  #
  # This implementation let you subclass the Singleton class while keeping just
  # one instance of each subclass around.
  def self.instance(value)
    return @instance if @instance

    @instance_mutex.synchronize do
      @instance ||= new(value)
    end

    @instance
  end

  # Finally, any singleton should define some business logic, which can be
  # executed on its instance.
  def some_business_logic
    # ...
  end
end

# @param [String] value
def test_singleton(value)
  singleton = Singleton.instance(value)
  puts singleton.value
end

# The client code.

puts "If you see the same value, then singleton was reused (yay!)\n"\
     "If you see different values, then 2 singletons were created (booo!!)\n\n"\
     "RESULT:\n\n"

process1 = Thread.new { test_singleton('FOO') }
process2 = Thread.new { test_singleton('BAR') }
process1.join
process2.join
