## This is the internal model that represent FT content in the publishing stack. This is not the same model exposed outside the stack

## Using this model

* Before depending on this component, consider whether the coupling that will create is worthwhile.  For example, if you will only ever want to extract a Title, you should not depend on this for such simple cases.
* Applications using this model must support the ability to ignore new fields if necessary

## Changing this model

* Where possible, changes to this lib should be backwards compatible. If you make breaking changes, you will have to ensure all consumers are updated and working

* Quite a few other components will depend on this one, so please minimise outgoing dependencies from this module to avoid future dependency hell for our consumers.

* Although this is a different model from the content api one, please remain consistent wherever sensible. (e.g., property names and semantics)

