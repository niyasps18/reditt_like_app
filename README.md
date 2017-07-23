"# RedditLikeApp v1.0"
RedditLikeApp is a very basic level clone of the real Reddit app. The app includes the functionalities defined in the
coding challenge document.

App Behaviour
-------------
The app preloads 10 posts on a fresh launch. Initially the upvotes/downvotes of each post is set to 0. The user can then
upvote or downvote the posts from the given list any number of time. The app assumes that only a single user uses the app
on a device. So if a user upvotes twice and downvotes once, then the total upvotes will be 1. The last vote that the user
performed will be highlighted. That means, if the user upvotes twice and then downvote once, the downward arrow will be
highlighted as the users last vote was a downvote.

The user can add a new post by clicking the add floating button present at the bottom right of the home page. The user
will be asked to enter a title and a body for the post, both of which are mandatory fields.

The post list is sorted based of upvotes. The post with highest number of upvotes will be on top of the list(descending).

The list shows the time since something is posted. The list displays "now" if the post is shared less than a minute ago.
Since the assumption is that the app on a particular device has a single user, "me" is displayed as username on each post.


--------------------------------------------------------------------------------------------------------------------------------
