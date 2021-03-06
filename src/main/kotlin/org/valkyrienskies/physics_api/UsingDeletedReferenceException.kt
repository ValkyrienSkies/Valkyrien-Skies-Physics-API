package org.valkyrienskies.physics_api

/**
 * This exception is thrown when the code tries using a reference that has been deleted.
 *
 * See [PhysicsWorldReference] or [RigidBodyReference] for more info.
 */
class UsingDeletedReferenceException(message: String) : RuntimeException(message)
