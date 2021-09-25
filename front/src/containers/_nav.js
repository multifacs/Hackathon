export default [
  {
    _name: 'CSidebarNav',
    _children: [
      {
        _name: 'CSidebarNavItem',
        name: 'Карта',
        to: '/dashboard',
        icon: 'cil-speedometer',
        badge: {
          color: 'warning',
          text: 'NEW'
        }
      },
      {
        _name: 'CSidebarNavItem',
        name: 'Предупреждения',
        to: '/warnings',
        icon: 'cil-drop'
      },
    ]
  }
]