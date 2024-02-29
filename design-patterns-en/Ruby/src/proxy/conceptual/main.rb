# Proxy Design Pattern
#
# Intent: Provide a surrogate or placeholder for another object to control
# access to the original object or to add other responsibilities.

# The Subject interface declares common operations for both RealSubject and the
# Proxy. As long as the client works with RealSubject using this interface,
# you'll be able to pass it a proxy instead of a real subject.
class Subject
  # @abstract
  def request
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# The RealSubject contains some core business logic. Usually, RealSubjects are
# capable of doing some useful work which may also be very slow or sensitive -
# e.g. correcting input data. A Proxy can solve these issues without any changes
# to the RealSubject's code.
class RealSubject < Subject
  def request
    puts 'RealSubject: Handling request.'
  end
end

# The Proxy has an interface identical to the RealSubject.
class Proxy < Subject
  # @param [RealSubject] real_subject
  def initialize(real_subject)
    @real_subject = real_subject
  end

  # The most common applications of the Proxy pattern are lazy loading, caching,
  # controlling the access, logging, etc. A Proxy can perform one of these
  # things and then, depending on the result, pass the execution to the same
  # method in a linked RealSubject object.
  def request
    return unless check_access

    @real_subject.request
    log_access
  end

  # @return [Boolean]
  def check_access
    puts 'Proxy: Checking access prior to firing a real request.'
    true
  end

  def log_access
    print 'Proxy: Logging the time of request.'
  end
end

# The client code is supposed to work with all objects (both subjects and
# proxies) via the Subject interface in order to support both real subjects and
# proxies. In real life, however, clients mostly work with their real subjects
# directly. In this case, to implement the pattern more easily, you can extend
# your proxy from the real subject's class.
def client_code(subject)
  # ...

  subject.request

  # ...
end

puts 'Client: Executing the client code with a real subject:'
real_subject = RealSubject.new
client_code(real_subject)

puts "\n"

puts 'Client: Executing the same client code with a proxy:'
proxy = Proxy.new(real_subject)
client_code(proxy)
