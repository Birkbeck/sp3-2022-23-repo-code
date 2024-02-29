# Memento Design Pattern
#
# Intent: Lets you save and restore the previous state of an object without
# revealing the details of its implementation.

# The Originator holds some important state that may change over time. It also
# defines a method for saving the state inside a memento and another method for
# restoring the state from it.
class Originator
  # For the sake of simplicity, the originator's state is stored inside a single
  # variable.
  attr_accessor :state
  private :state

  # @param [String] state
  def initialize(state)
    @state = state
    puts "Originator: My initial state is: #{@state}"
  end

  # The Originator's business logic may affect its internal state. Therefore,
  # the client should backup the state before launching methods of the business
  # logic via the save() method.
  def do_something
    puts 'Originator: I\'m doing something important.'
    @state = generate_random_string(30)
    puts "Originator: and my state has changed to: #{@state}"
  end

  private def generate_random_string(length = 10)
    ascii_letters = [*'a'..'z', *'A'..'Z']
    (0...length).map { ascii_letters.sample }.join
  end

  # Saves the current state inside a memento.
  def save
    ConcreteMemento.new(@state)
  end

  # Restores the Originator's state from a memento object.
  def restore(memento)
    @state = memento.state
    puts "Originator: My state has changed to: #{@state}"
  end
end

# The Memento interface provides a way to retrieve the memento's metadata, such
# as creation date or name. However, it doesn't expose the Originator's state.
class Memento
  # @abstract
  #
  # @return [String]
  def name
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # @abstract
  #
  # @return [String]
  def date
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

class ConcreteMemento < Memento
  # @param [String] state
  def initialize(state)
    @state = state
    @date = Time.now.strftime('%F %T')
  end

  # The Originator uses this method when restoring its state.
  attr_reader :state

  # The rest of the methods are used by the Caretaker to display metadata.
  def name
    "#{@date} / (#{@state[0, 9]}...)"
  end

  # @return [String]
  attr_reader :date
end

# The Caretaker doesn't depend on the Concrete Memento class. Therefore, it
# doesn't have access to the originator's state, stored inside the memento. It
# works with all mementos via the base Memento interface.
class Caretaker
  # @param [Originator] originator
  def initialize(originator)
    @mementos = []
    @originator = originator
  end

  def backup
    puts "\nCaretaker: Saving Originator's state..."
    @mementos << @originator.save
  end

  def undo
    return if @mementos.empty?

    memento = @mementos.pop
    puts "Caretaker: Restoring state to: #{memento.name}"

    begin
      @originator.restore(memento)
    rescue StandardError
      undo
    end
  end

  def show_history
    puts 'Caretaker: Here\'s the list of mementos:'

    @mementos.each { |memento| puts memento.name }
  end
end

originator = Originator.new('Super-duper-super-puper-super.')
caretaker = Caretaker.new(originator)

caretaker.backup
originator.do_something

caretaker.backup
originator.do_something

caretaker.backup
originator.do_something

puts "\n"
caretaker.show_history

puts "\nClient: Now, let's rollback!\n"
caretaker.undo

puts "\nClient: Once more!\n"
caretaker.undo
