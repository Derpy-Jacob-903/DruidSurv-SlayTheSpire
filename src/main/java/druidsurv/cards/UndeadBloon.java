package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.onedelaybloon;

import static druidsurv.ModFile.makeID;

public class UndeadBloon extends AbstractEasyCard {
    public final static String ID = makeID("UndeadBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public UndeadBloon() {
        super(ID, 0, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS);
        baseDamage = 14;
        baseBlock = 0;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        //setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new onedelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        //blck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(7);
        //upgradeBlock(0);
    }
}