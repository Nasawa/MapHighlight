# MapHighlight

A proof of concept Android app for tappable, color-coded regions on a map or floor plan. Tap a region, get a label back.

## What It Does

The app draws a canvas with rectangular room overlays on top of a floor plan image. Each room is either available (green) or reserved (red). Tapping a region shows a Snackbar with the room name and its status.

The intended use case is something like a room booking display — show a floor plan, highlight rooms by availability, let users tap to find out what's what.

## Architecture

| File | Purpose |
|------|---------|
| `MainActivity.java` | Sets up the touch listener on the canvas |
| `CanvasView.java` | Custom view — draws colored overlays for each room, handles tap-to-room detection |
| `Room.java` | Data model — name, bounding `Rect`, and reserved flag |

The hit detection works by checking if the touch coordinates fall within a room's `Rect`. The color is determined at draw time: green with alpha for available, red with alpha for reserved.

## How to Run

Open in Android Studio. Requires Android 5.0+ (uses `Snackbar` from the design support library). Build and run on a device or emulator.

The demo hardcodes two rooms: a "Bedroom" (green, available) and "Utility" (red, reserved). To make it useful, you'd replace the `addRooms()` call with data from a backend and swap in an actual floor plan image.

## Notes

Built in 2016 as a standalone proof of concept. The rectangle-based approach is simple and effective for grid-like floor plans; irregular shapes would need polygon hit testing instead.
