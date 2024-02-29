/// Observer Design Pattern
///
/// Intent: Lets you define a subscription mechanism to notify multiple objects
/// about any events that happen to the object they're observing.
///
/// Note that there's a lot of different terms with similar meaning associated
/// with this pattern. Just remember that the Subject is also called the
/// Publisher and the Observer is often called the Subscriber and vice versa.
/// Also the verbs "observe", "listen" or "track" usually mean the same thing.
///
/// Swift language has multiple ways of implementing the Observer pattern:
///
/// - KVO. Here is an example of how to implement it in a dozen lines of code:
/// https://www.objc.io/blog/2018/04/24/bindings-with-kvo-and-keypaths/
///
/// - NotificationCenter
/// https://developer.apple.com/documentation/foundation/notificationcenter
///
/// - RxSwift:
/// https://github.com/ReactiveX/RxSwift
///
/// In this example we'll implement a custom observer from scratch.

import XCTest

/// The Subject owns some important state and notifies observers when the state
/// changes.
class Subject {

    /// For the sake of simplicity, the Subject's state, essential to all
    /// subscribers, is stored in this variable.
    var state: Int = { return Int(arc4random_uniform(10)) }()

    /// @var array List of subscribers. In real life, the list of subscribers
    /// can be stored more comprehensively (categorized by event type, etc.).
    private lazy var observers = [Observer]()

    /// The subscription management methods.
    func attach(_ observer: Observer) {
        print("Subject: Attached an observer.\n")
        observers.append(observer)
    }

    func detach(_ observer: Observer) {
        if let idx = observers.firstIndex(where: { $0 === observer }) {
            observers.remove(at: idx)
            print("Subject: Detached an observer.\n")
        }
    }

    /// Trigger an update in each subscriber.
    func notify() {
        print("Subject: Notifying observers...\n")
        observers.forEach({ $0.update(subject: self)})
    }

    /// Usually, the subscription logic is only a fraction of what a Subject can
    /// really do. Subjects commonly hold some important business logic, that
    /// triggers a notification method whenever something important is about to
    /// happen (or after it).
    func someBusinessLogic() {
        print("\nSubject: I'm doing something important.\n")
        state = Int(arc4random_uniform(10))
        print("Subject: My state has just changed to: \(state)\n")
        notify()
    }
}

/// The Observer protocol declares the update method, used by subjects.
protocol Observer: class {

    func update(subject: Subject)
}

/// Concrete Observers react to the updates issued by the Subject they had been
/// attached to.
class ConcreteObserverA: Observer {

    func update(subject: Subject) {

        if subject.state < 3 {
            print("ConcreteObserverA: Reacted to the event.\n")
        }
    }
}

class ConcreteObserverB: Observer {

    func update(subject: Subject) {

        if subject.state >= 3 {
            print("ConcreteObserverB: Reacted to the event.\n")
        }
    }
}

/// Let's see how it all works together.
class ObserverConceptual: XCTestCase {

    func testObserverConceptual() {

        let subject = Subject()

        let observer1 = ConcreteObserverA()
        let observer2 = ConcreteObserverB()

        subject.attach(observer1)
        subject.attach(observer2)

        subject.someBusinessLogic()
        subject.someBusinessLogic()
        subject.detach(observer2)
        subject.someBusinessLogic()
    }
}
