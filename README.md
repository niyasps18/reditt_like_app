App Quick Details
------------------
Name: RedditLikeApp
Version: 1.0
Author: Niyas Sajjad
Minimum SDK API level: 21 (Lollipop and above)

-------------------------------------------------------------------

RedditLikeApp is a very basic level clone of the real Reddit app. The app includes the functionalities defined in the
coding challenge document.

App Behaviour
-------------
The app preloads 20 posts on a fresh launch. Initially the upvotes/downvotes of each post is set to a random number between 0 and 15. The user can then
upvote or downvote the posts from the given list any number of time. The app assumes that only a single user uses the app
on a device. So if a user upvotes twice and downvotes once, then the total upvotes will be 1 and the post will be placed
in the list of all posts according to this rating as a result of the sorting procedure. The last vote that the user
performed will be highlighted. That means, if the user upvotes twice and then downvote once, the downward arrow will be
highlighted as the users last vote was a downvote. If the user downvotes while the total number of votes is zero, the the
app displays -1 for the vote count which is the effective vote count for that post.

The user can add a new post by clicking the add floating button present at the bottom right of the home page. The user
will be asked to enter a title and a body for the post, both of which are mandatory fields. A new post made by the user
will be upvoted by 1 by default.

The post list is sorted based of upvotes. The post with highest number of upvotes will be on top of the list(descending).

The list shows the time since something is posted. The list displays "now" if the post is shared less than a minute ago.
Since the assumption is that the app on a particular device has a single user, "me" is displayed as username on each post.

When the user scrolls and reaches the bottom of the list, more data is loaded. This seems to be a more scalable model than
just showing a limitted number of posts all the time.

Upon clicking the downvote/upvote button the list will get instantly sorted if necessary.

--------------------------------------------------------------------------------------------------------------------------------

Test using Espresso
-------------------
Tests for Floating action button click and creating a post are added using espresso.
--------------------------------------------------------------------------------------------------------------------------------
