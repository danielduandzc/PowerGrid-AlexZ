# PowerGrid-AlexZ

Java/Swing hot-seat implementation of Power Grid: Recharged, using the existing project assets.

## Run

From the repository root:

```bash
javac src/*.java
java src.Main
```

## What Is Implemented

- 3 or 4 local players
- Germany map screen with a six-region, 42-city buildable graph and connection costs
- Power plant deck setup, current/future market, discount plant, auctions, and three-plant ownership limit
- Coal, oil, garbage, and uranium market with buying, storage, consumption, and refill
- Reverse-order resource buying and house building
- Bureaucracy payouts, market refresh, Step 2, Step 3, Germany uranium phase-out after plant 39, and end-game scoring

## Notes

The UI is hot-seat only: players share one computer and click through each phase. The map data lives inside `CityGraph`, and the project board art is used as the visual backdrop.
