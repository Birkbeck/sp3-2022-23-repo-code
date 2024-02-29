# Observer Design Pattern
#
# Intent: Lets you define a subscription mechanism to notify multiple objects
# about any events that happen to the object they're observing.
#
# Note that there's a lot of different terms with similar meaning associated
# with this pattern. Just remember that the Subject is also called the Publisher
# and the Observer is often called the Subscriber and vice versa. Also the verbs
# "observe", "listen" or "track" usually mean the same thing.

# The Subject interface declares a set of methods for managing subscribers.
class Subject
  # Attach an observer to the subject.
  def attach(observer)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # Detach an observer from the subject.
  def detach(observer)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end

  # Notify all observers about an event.
  def notify
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# The Subject owns some important state and notifies observers when the state
# changes.
class ConcreteSubject < Subject
  # For the sake of simplicity, the Subject's state, essential to all
  # subscribers, is stored in this variable.
  attr_accessor :state

  # @!attribute observers
  # @return [Array<Observer>] attr_accessor :observers private :observers

  def initialize
    @observers = []
  end

  # List of subscribers. In real life, the list of subscribers can be stored
  # more comprehensively (categorized by event type, etc.).

  # @param [Obserser] observer
  def attach(observer)
    puts 'Subject: Attached an observer.'
    @observers << observer
  end

  # @param [Obserser] observer
  def detach(observer)
    @observers.delete(observer)
  end

  # The subscription management methods.

  # Trigger an update in each subscriber.
  def notify
    puts 'Subject: Notifying observers...'
    @observers.each { |observer| observer.update(self) }
  end

  # Usually, the subscription logic is only a fraction of what a Subject can
  # really do. Subjects commonly hold some important business logic, that
  # triggers a notification method whenever something important is about to
  # happen (or after it).
  def some_business_logic
    puts "\nSubject: I'm doing something important."
    @state = rand(0..10)

    puts "Subject: My state has just changed to: #{@state}"
    notify
  end
end

# The Observer interface declares the update method, used by subjects.
class Observer
  # Receive update from subject.
  def update(_subject)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# Concrete Observers react to the updates issued by the Subject they had been
# attached to.

class ConcreteObserverA < Observer
  # @param [Subject] subject
  def update(subject)
    puts 'ConcreteObserverA: Reacted to the event' if subject.state < 3
  end
end

class ConcreteObserverB < Observer
  # @param [Subject] subject
  def update(subject)
    return unless subject.state.zero? || subject.state >= 2

    puts 'ConcreteObserverB: Reacted to the event'
  end
end

# The client code.

subject = ConcreteSubject.new

observer_a = ConcreteObserverA.new
subject.attach(observer_a)

observer_b = ConcreteObserverB.new
subject.attach(observer_b)

subject.some_business_logic
subject.some_business_logic

subject.detach(observer_a)

subject.some_business_logic
