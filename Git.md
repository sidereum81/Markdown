
Google Repo
-----------
https://gerrit.googlesource.com/git-repo/+/stable/docs/manifest-format.txt
https://harrow.io/blog/using-repo-to-manage-complex-software-projects/

Jenkins
-------
https://jenkins.io/doc/book/pipeline/

Branch strategy
---------------
http://wiki.qt.io/Gerrit_Introduction#Topics_vs._Branches
http://wiki.qt.io/Branch_Guidelines



git log --oneline --decorate --graph        # tip: configure an alias for this command, e.g: git config --global alias.lol "log --oneline --decorate --graph --color"

git log --pretty=format:"%h %ad %aN %s" --date=format:"%Y-%m-%d %H:%M"        # tip: configure an alias, e.g: git config --global alias.lof 'log --pretty=format:"%h %ad %aN %s" --date=format:"%Y-%m-%d %H:%M"'


There is also fast command line tool Tig: https://jonas.github.io/tig/