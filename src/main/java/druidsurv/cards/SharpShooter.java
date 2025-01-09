package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.reload;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class SharpShooter extends AbstractEasyCard {
    public final static String ID = makeID("SharpShooter");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SharpShooter() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 15;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new DamageAction(m, new DamageInfo(AbstractDungeon.player, damage*2, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}